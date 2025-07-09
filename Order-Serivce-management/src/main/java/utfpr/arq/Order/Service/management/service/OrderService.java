package utfpr.arq.Order.Service.management.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.arq.Order.Service.management.dto.EmailDTO;
import utfpr.arq.Order.Service.management.model.ServiceOrderModel;
import utfpr.arq.Order.Service.management.producer.EmailSender;
import utfpr.arq.Order.Service.management.repository.ServiceOrderRepository;

@Service
public class OrderService {
    //Injeção de dependência para o repositório que será utilizado no serviço
    //Todas as operações de CRUD são feitas através do repositório
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private EmailSender emailSender;

    public void saveOrder(ServiceOrderModel order) {
        serviceOrderRepository.save(order);
        if ("Finalizada".equalsIgnoreCase(order.getStatus())) {
            EmailDTO emailDTO = new EmailDTO(
            UUID.randomUUID(), // ou o ID do usuário, se houver
            order.getCustomerEmail(),
            "Confirmação de finalização de OS!",
            "Olá, " + order.getCustomerName() + " sua ordem de serviço foi finalizada com sucesso."
        );
        emailSender.sendEmail(emailDTO);
    }
    }

    public void deleteOrder(int id) {
        serviceOrderRepository.deleteById(id);
    }
    public ServiceOrderModel findOrderById(int id) {
        return serviceOrderRepository.findById(id).orElse(null);
    }
    public List<ServiceOrderModel> findAllOrders() {
        return serviceOrderRepository.findAll();
    }
}
