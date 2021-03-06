package pl.coderslab.controller.client;

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
public class DietController {


    private final DietService dietService;
    private final DietRepository dietRepository;

    public DietController(DietService dietService, DietRepository dietRepository) {
        this.dietService = dietService;
        this.dietRepository = dietRepository;
    }

    @ModelAttribute("kcal")
    public List<Integer> kcal(HttpSession session) {
        List<Integer> listKcal = Arrays.asList(1500, 2000, 2500, 3000);
        session.setAttribute("kcal", listKcal);
        return Arrays.asList(1500, 2000, 2500, 3000);
    }

    @GetMapping("/diets")
    public String diets(Model model) {
        model.addAttribute("diets", dietService.findAll());
        return "views/diets";
    }

    @GetMapping("/diets/{id}")
    public String dietsId(@PathVariable Long id, Model model, HttpSession session) {
        Optional<Diet> diet = dietRepository.findById(id);
        session.setAttribute("diet", diet.get());
        model.addAttribute("order", new Order());
        return "form/diets-service";
    }

    @PostMapping("/diets/{idDiet}")
    @ResponseBody
    public String dietsId(@PathVariable Long idDiet,
                          @RequestParam String kcal,
                          @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                          @RequestParam("expireDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expireDate,
                          HttpSession session) {
        dietService.setDietRequestedDataToSession(idDiet, kcal, startDate, expireDate, session);
        return printOrderData(idDiet, kcal, startDate, expireDate);
    }

    private String printOrderData(Long idDiet, String kcal, LocalDate startDate, LocalDate expireDate) {
        Optional<Diet> diet = dietRepository.findById(idDiet);
        Double price = dietService.getPrizeWholePlan(kcal, startDate, expireDate, idDiet);
        return "<h1>Your order</h1>" +
                "<p>Type of diet: " + diet.get().getName() +
                "</p><p>Start order: " +
                startDate +
                "</p><p>Expire order: " +
                expireDate + "</p>" +
                "<p>Amount of daily kcal: " + kcal +
                "</p><p>Total cost: " + price +
                "</p><a href='/order'>click to enter your data</a>";
    }
}
