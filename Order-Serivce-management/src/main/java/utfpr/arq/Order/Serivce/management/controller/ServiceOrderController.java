package utfpr.arq.Order.Serivce.management.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import utfpr.arq.Order.Serivce.management.model.ServiceOrderRepository;


@Controller
public class ServiceOrderController {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contentTemplate", "index");
        model.addAttribute("contentFragment", "content");
        return "layout";
    }

    @GetMapping("/orders")
    public String listarOrdens(Model model) {
        model.addAttribute("orders", serviceOrderRepository.findAll());
        model.addAttribute("contentTemplate", "ordersList");
        model.addAttribute("contentFragment", "content");
        return "layout";
    }

    @GetMapping("/ordersForm")
    public String cadastrarOrdem(Model model) {
        model.addAttribute("contentTemplate", "formServiceOrder");
        model.addAttribute("contentFragment", "content");
        return "layout";
    }

    @DeleteMapping("/orders/delete/{id}")
    public String deletarOrdem(@PathVariable(value = "id") int id) {
        serviceOrderRepository.deleteById(id);
        return "redirect:/orders";
    }
}
