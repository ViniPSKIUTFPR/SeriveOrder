package utfpr.arq.Order.Serivce.management.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import utfpr.arq.Order.Serivce.management.model.ServiceOrderModel;

@Controller
public class ServiceOrderController {

    private final List<ServiceOrderModel> serviceOrders = List.of(
            new ServiceOrderModel("1", "John Doe", "Pending"),
            new ServiceOrderModel("2", "Jane Smith", "Completed"),
            new ServiceOrderModel("3", "Alice Johnson", "In Progress")
    );

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/orders")
    public String listarOrdens(Model model) {
        model.addAttribute("orders", serviceOrders);
        return "ordersList";
    }
}
