package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;
    private UserRepository userRepository;


    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "DD";
    }


    @GetMapping("/admin")
    public String forAdmin(Model model) {
        model.addAttribute("users", userService.findAll());
        return "views/admin";
    }


    @GetMapping("/user")
    @ResponseBody
    public String forUser() {
        return "form/helloUser";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(new User());
        return "form/register";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "form/register";
        }
        userService.add(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(new User());
        return "form/login";
    }


    @GetMapping("/successLogin")
    public String successLogin(HttpServletRequest req) {
        if (req.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        return "redirect:/user";
    }

}
