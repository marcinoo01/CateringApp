package pl.coderslab.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Client;
import pl.coderslab.repository.CityRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.OrderService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class OrderUserController {

    private final OrderService orderService;
    private final UserRepository userRepository;
    private final CityRepository cityRepository;

    public OrderUserController(OrderService orderService, UserRepository userRepository, CityRepository cityRepository) {
        this.orderService = orderService;
        this.userRepository = userRepository;
        this.cityRepository = cityRepository;
    }


    @ModelAttribute("cityName")
    public List<String> cities() {
        return Arrays.asList("Cracow", "Warsaw", "Gdansk", "Wrocław", "Łódź");
    }


    @GetMapping("/user/order/{id}")
    public String order(Model model, HttpSession session, @PathVariable Long id) {
        Client client = new Client();
        String email = userRepository.findById(id).get().getEmail();
        session.setAttribute("email", email);
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute(client);
        return "user/order-diet";
    }

    @PostMapping("/user/order/{id}")
    public String order(@Valid Client client, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "user/order-diet";
        }
        orderService.setOrderRequestedDataToSession(client, session);
        return "redirect:/user/payment";
    }
}
