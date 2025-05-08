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
    
    @Autowired
    private ServicesService servicesService;

    @GetMapping("/services")
    public String listarServicos(Model model) {
        model.addAttribute("servicesList", servicesService.listarServicos());
        model.addAttribute("contentTemplate", "servicesList");
        return "layout";
    }

    @GetMapping("/servicesForm")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("servicesModel", new ServicesModel());
        model.addAttribute("contentTemplate", "formServices");
        return "layout";
    }

    @PostMapping("/servicesForm")
    public String salvarServico(@ModelAttribute ServicesModel service) {
        servicesService.salvarServico(service);
        return "redirect:/services";
    }

    @GetMapping("/services/edit/{id}")
    public String exibirFormularioEdicao(@PathVariable int id, Model model) {
        ServicesModel service = servicesService.buscarPorId(id);
        model.addAttribute("servicesModel", service); 
        model.addAttribute("contentTemplate", "formServices");
        return "layout";
    }

    @GetMapping("/services/delete/{id}")
    public String deletarServico(@PathVariable int id) {
        servicesService.deletarPorId(id);
        return "redirect:/services";
    }

}