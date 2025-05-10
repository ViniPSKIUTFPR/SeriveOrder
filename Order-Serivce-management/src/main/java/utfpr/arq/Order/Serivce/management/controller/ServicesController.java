package utfpr.arq.Order.Serivce.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import utfpr.arq.Order.Serivce.management.model.ServicesModel;
import utfpr.arq.Order.Serivce.management.service.ServicesService;

@Controller
public class ServicesController {
    
    //Injeção de dependência para o serviço que sera utilizado no controlador
    @Autowired
    private ServicesService servicesService;

    @GetMapping("/services")
    public String listarServicos(Model model) {
        //Lista os serviços cadastrados
        model.addAttribute("servicesList", servicesService.listarServicos());
        model.addAttribute("contentTemplate", "servicesList");
        return "layout";
    }

    @GetMapping("/servicesForm")
    public String exibirFormularioCadastro(Model model) {
        //Adicionar um novo objeto de serviço ao modelo para o formulário
        model.addAttribute("servicesModel", new ServicesModel());
        model.addAttribute("contentTemplate", "formServices");
        return "layout";
    }

    @PostMapping("/servicesForm")
    public String salvarServico(@ModelAttribute ServicesModel service) {
        //Salvar o serviço
        servicesService.salvarServico(service);
        return "redirect:/services";
    }

    @GetMapping("/services/edit/{id}")
    public String exibirFormularioEdicao(@PathVariable int id, Model model) {
        //Buscar o serviço pelo id
        ServicesModel service = servicesService.buscarPorId(id);
        //Adicionar o serviço ao modelo
        model.addAttribute("servicesModel", service); 
        model.addAttribute("contentTemplate", "formServices");
        return "layout";
    }

    @GetMapping("/services/delete/{id}")
    public String deletarServico(@PathVariable int id) {
        //Deletar o serviço pelo id
        servicesService.deletarPorId(id);
        return "redirect:/services";
    }

}