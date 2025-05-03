package utfpr.arq.Order.Serivce.management.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import utfpr.arq.Order.Serivce.management.model.OrderServicesModel;

@Controller
public class ServiceOrderController {
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contentTemplate", "index");
        model.addAttribute("contentFragment", "content");
        return "layout";
    }

    @GetMapping("/orders")
    public String listarOrdens(Model model) {
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
}
