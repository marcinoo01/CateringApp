package pl.coderslab.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Client;
import pl.coderslab.service.OrderService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ModelAttribute("cityName")
    public List<String> cities() {
        return Arrays.asList("Cracow", "Warsaw", "Gdansk", "Wrocław", "Łódź");
    }


    @GetMapping("/order")
    public String order(Model model, HttpSession session) {
        Client client = new Client();
        String dietName = (String) session.getAttribute("dietName");
        client.setDiet(dietName);
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
