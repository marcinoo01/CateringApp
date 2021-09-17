package pl.coderslab.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Client;
import pl.coderslab.repository.CityRepository;
import pl.coderslab.service.OrderService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final CityRepository cityRepository;

    public OrderController(OrderService orderService, CityRepository cityRepository) {
        this.orderService = orderService;
        this.cityRepository = cityRepository;
    }


    @GetMapping("/order")
    public String order(Model model) {
        model.addAttribute("cities", cityRepository.findAll());
        Client client = new Client();
        model.addAttribute(client);
        return "form/order-diet";
    }

    @PostMapping("/order")
    public String order(@Valid Client client, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "form/order-diet";
        }
        orderService.setOrderRequestedDataToSession(client, session);
        return "redirect:/payment";
    }


}
