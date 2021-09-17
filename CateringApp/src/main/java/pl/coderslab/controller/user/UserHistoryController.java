package pl.coderslab.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.OrderRepository;
import pl.coderslab.repository.UserRepository;

import java.security.Principal;

@Controller
public class UserHistoryController {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public UserHistoryController(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @RequestMapping("/user/history")
    public String history(Model model, Principal principal) {
        String name = principal.getName();
        Long idUser = userRepository.findByusername(name).get().getId();
        model.addAttribute("history", orderRepository.findAllByUserId(idUser));
        return "user/history";
    }

}
