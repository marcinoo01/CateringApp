package pl.coderslab.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.service.DietService;

import javax.servlet.http.HttpSession;

@Controller
public class PrizeController {

    private final DietService dietService;

    public PrizeController(DietService dietService) {
        this.dietService = dietService;
    }

    @GetMapping("/price-list")
    public String priceList(Model model, HttpSession session){
        model.addAttribute("diets", dietService.findAll());
        model.addAttribute("kcal", session.getAttribute("kcal"));
        return "views/price-list";
    }
}
