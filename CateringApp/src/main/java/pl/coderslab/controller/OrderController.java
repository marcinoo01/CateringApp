package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Client;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class OrderController {

    @ModelAttribute("cityName")
    public List<String> cities() {
        return Arrays.asList("Cracow", "Warsaw", "Gdansk", "Wrocław", "Łódź");
    }


    @GetMapping("/order")
    public String order(Model model) {
        model.addAttribute(new Client());
        return "form/order-diet";
    }

    @PostMapping("/order")
    public String order(@Valid Client client, BindingResult result){
        if(result.hasErrors()){
            return "form/order-diet";
        }
        client.getAddress();
        return "/payment";
    }

    @GetMapping("/payment")
    @ResponseBody
    public String payment(){
        return "?";
    }

}
