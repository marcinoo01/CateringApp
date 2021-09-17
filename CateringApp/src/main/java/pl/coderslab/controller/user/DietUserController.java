package pl.coderslab.controller.user;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Diet;
import pl.coderslab.model.Order;
import pl.coderslab.repository.DietRepository;
import pl.coderslab.service.DietService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class DietUserController {
    private final DietRepository dietRepository;
    private final DietService dietService;

    public DietUserController(DietRepository dietRepository, DietService dietService) {
        this.dietRepository = dietRepository;
        this.dietService = dietService;
    }

    @ModelAttribute("kcal")
    public List<Integer> kcal(HttpSession session) {
        List<Integer> listKcal = Arrays.asList(1500, 2000, 2500, 3000);
        session.setAttribute("kcal", listKcal);
        return Arrays.asList(1500, 2000, 2500, 3000);
    }


    @GetMapping("user/diets")
    public String dietUser(Model model, HttpSession session){
        model.addAttribute("idUser" , session.getAttribute("idUser"));
        model.addAttribute("diets", dietService.findAll());
        return "user/select-diet";
    }

    @GetMapping("/user/diets/{idUser}/{idDiet}")
    public String orderUser(Model model) {
        model.addAttribute(new Order());
        return "user/diet-selection";
    }

    @PostMapping("/user/diets/{idUser}/{idDiet}")
    public String orderUser(@PathVariable Long idDiet,
                          @RequestParam String kcal,
                          @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                          @RequestParam("expireDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expireDate,
                          HttpSession session, Model model) {
        Double price = dietService.getPrizeWholePlan(kcal, startDate, expireDate, idDiet);
        Optional<Diet> diet = dietRepository.findById(idDiet);
        session.setAttribute("diet", diet.get());
        model.addAttribute("startDate", startDate);
        model.addAttribute("expireDate", expireDate);
        model.addAttribute("kcal", kcal);
        model.addAttribute("id");
        model.addAttribute("price", price);
        model.addAttribute("idUser", session.getAttribute("idUser"));
        model.addAttribute("dietName", diet.get());
        dietService.setDietRequestedDataToSession(idDiet, kcal, startDate, expireDate, session);
        return "user/diet-order-view";
    }
}
