package pl.coderslab.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class LoginUserController {

    private final UserRepository userRepository;

    public LoginUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/user")
    public String forUser(Principal principal, Model model, HttpSession session) {
        model.addAttribute("username", principal.getName());
        session.setAttribute("idUser", userRepository.findByusername(principal.getName()).get().getId());
        return "user/helloUser";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(new User());
        return "user/login";
    }

    @RequestMapping("/login/history")
    public String history(Model model, Principal principal){
        model.addAttribute("historyList", principal.getName());
        return "views/history";
    }


}
