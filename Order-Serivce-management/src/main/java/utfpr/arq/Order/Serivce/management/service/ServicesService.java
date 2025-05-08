package utfpr.arq.Order.Serivce.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.arq.Order.Serivce.management.model.ServicesModel;
import utfpr.arq.Order.Serivce.management.repository.ServicesRepository;

@Service
public class ServicesService {
    
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