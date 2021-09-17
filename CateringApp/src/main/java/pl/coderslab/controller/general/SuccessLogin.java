package pl.coderslab.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SuccessLogin {
    @GetMapping("/successLogin")
    public String successLogin(HttpServletRequest req) {
        if (req.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        return "redirect:/user";
    }
}
