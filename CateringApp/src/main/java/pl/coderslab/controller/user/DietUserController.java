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

    @GetMapping("/user/diets/{idDiet}")
    public String orderUser(Model model) {
        model.addAttribute(new Order());
        return "user/diet-selection";
    }

    @PostMapping("/user/diets/{idDiet}")
    @ResponseBody
    public String orderUser(@PathVariable Long idDiet,
                          @RequestParam String kcal,
                          @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                          @RequestParam("expireDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expireDate,
                          HttpSession session) {
        dietService.setDietRequestedDataToSession(idDiet, kcal, startDate, expireDate, session);
        return printOrderData(idDiet, kcal, startDate, expireDate);
    }

    private String printOrderData(Long idDiet, String kcal, LocalDate startDate, LocalDate expireDate) {
        Optional<Diet> diet = dietRepository.findById(idDiet);
        if(!diet.isPresent()){
            return "Diet not selected";
        }
        Double price = dietService.getPrizeWholePlan(kcal, startDate, expireDate, idDiet);
        return "<h1>Your order</h1>" +
                "<p>Type of diet: " + diet.get().getDietName() +
                "</p><p>Start order: " +
                startDate +
                "</p><p>Expire order: " +
                expireDate + "</p>" +
                "<p>Amount of daily kcal: " + kcal +
                "</p><p>Total cost: " + price +
                "</p><a href='/user/order/{id}'>click to enter your data</a>";
    }
}
