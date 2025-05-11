package utfpr.arq.Order.Service.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.arq.Order.Service.management.model.ServiceOrderModel;
import utfpr.arq.Order.Service.management.repository.ServiceOrderRepository;

@Service
public class OrderService {
    //Injeção de dependência para o repositório que será utilizado no serviço
    //Todas as operações de CRUD são feitas através do repositório
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public void saveOrder(ServiceOrderModel order) {
        serviceOrderRepository.save(order);
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
