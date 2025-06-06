package utfpr.arq.Order.Service.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utfpr.arq.Order.Service.management.model.ServicesModel;
import utfpr.arq.Order.Service.management.repository.ServicesRepository;

@Service
public class ServicesService {
    //Injeção de dependência para o repositório que será utilizado no serviço
    //Todas as operações de CRUD são feitas através do repositório
    @Autowired
    private ServicesRepository servicesRepository;

    public List<ServicesModel> listarServicos() {
        return servicesRepository.findAll();
    }

    public void salvarServico(ServicesModel servico) {
        servicesRepository.save(servico);
    }

    public ServicesModel buscarPorId(int id) {
        return servicesRepository.findById(id).orElse(null);
    }
    
    public void deletarPorId(int id) {
        servicesRepository.deleteById(id);
    }
}