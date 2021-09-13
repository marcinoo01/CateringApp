package pl.coderslab.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.service.UserService;

@Controller
public class LoginAdminController {
    private UserService userService;

    public LoginAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String forAdmin(Model model) {
        model.addAttribute("users", userService.findAll());
        return "views/admin";
    }
}
