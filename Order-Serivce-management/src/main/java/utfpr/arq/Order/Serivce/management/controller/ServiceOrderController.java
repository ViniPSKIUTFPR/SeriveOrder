package utfpr.arq.Order.Serivce.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import utfpr.arq.Order.Serivce.management.model.OrderServicesModel;
import utfpr.arq.Order.Serivce.management.model.ServiceOrderModel;
import utfpr.arq.Order.Serivce.management.service.OrderService;
import utfpr.arq.Order.Serivce.management.service.ServicesService;


@Controller
public class ServiceOrderController {

    //Injeções de dependência para os serviços que serão utilizados no controlador
    @Autowired
    private OrderService orderService;

    @Autowired
    private ServicesService servicesService;
    
    @GetMapping("/")
    public String index(Model model) {
        // Exibir a página inicial
        model.addAttribute("contentTemplate", "index");
        model.addAttribute("contentFragment", "content");
        return "layout";
    }

    @GetMapping("/orders")
    public String listarOrdens(Model model) {
        // Adiciona a lista de ordens de serviço para exibição
        model.addAttribute("orders", orderService.findAllOrders());
        model.addAttribute("contentTemplate", "ordersList");
        model.addAttribute("contentFragment", "content");
        return "layout";
    }

    @GetMapping("/ordersForm")
    public String cadastrarOrdem(Model model) {
        /*  Adiciona os serviços disponíveis para seleção no modal
         e cria uma nova ordem de serviço
         para ser preenchida no formulário*/
        model.addAttribute("services", servicesService.listarServicos());
        model.addAttribute("serviceOrder", new ServiceOrderModel());
        model.addAttribute("contentTemplate", "formServiceOrder");
        model.addAttribute("contentFragment", "content");
        return "layout";
    }

    @GetMapping("/ordersForm/{id}")
    public String editarOrdem(@PathVariable(value = "id") int id, Model model) {
        /* Busca a ordem de serviço pelo id para edição
         e adiciona os serviços disponíveis para seleção no modal */
        ServiceOrderModel serviceOrder = orderService.findOrderById(id);
        model.addAttribute("services", servicesService.listarServicos());
        model.addAttribute("serviceOrder", serviceOrder);
        model.addAttribute("contentTemplate", "formServiceOrder");
        model.addAttribute("contentFragment", "content");
        return "layout";
    }

    @GetMapping("/orders/delete/{id}")
    public String deletarOrdem(@PathVariable(value = "id") int id) {
        //Deleta a ordem de serviço de acordo com o id
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    @PostMapping("/service-order/save")
    public String saveServiceOrder(@ModelAttribute ServiceOrderModel serviceOrder) {
        // Associa cada serviço à ordem de serviço
        if (serviceOrder.getServices() != null) {
            for (OrderServicesModel service : serviceOrder.getServices()) {
                service.setOrder(serviceOrder); // Associa o serviço à ordem
            }
        }
        // Salva a ordem de serviço e os serviços associados
        orderService.saveOrder(serviceOrder);

        return "redirect:/orders";
    }
}
