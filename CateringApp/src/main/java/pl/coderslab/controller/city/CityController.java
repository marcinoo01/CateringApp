package pl.coderslab.controller.city;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.repository.CityRepository;

@Controller
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @GetMapping("/localizations")
    public String localizations(Model model){
        model.addAttribute("cities", cityRepository.findAll());
        return "city/view";
    }
}
