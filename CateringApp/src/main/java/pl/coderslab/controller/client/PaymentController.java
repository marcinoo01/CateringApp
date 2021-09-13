package pl.coderslab.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.service.ClientService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class PaymentController {

    private ClientService clientService;

    public PaymentController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/payment")
    public String payment() {
        return "form/payment";
    }

    @PostMapping("/payment")
    @ResponseBody
    public String payment(@RequestParam String typeOfPayment, HttpSession session) {
        String dietName = (String) session.getAttribute("dietName");
        String kcal = (String) session.getAttribute("kcal");
        LocalDate startDate = (LocalDate) session.getAttribute("startDate");
        LocalDate expireDate = (LocalDate) session.getAttribute("expireDate");
        Double prize = (Double) session.getAttribute("prize");
        String address = (String) session.getAttribute("address");
        String email = (String) session.getAttribute("email");
        String surname = (String) session.getAttribute("surname");
        String zip = (String) session.getAttribute("zip");
        String city = (String) session.getAttribute("city");
        String name = (String) session.getAttribute("name");
        Long phoneNumber = (Long) session.getAttribute("phoneNumber");
        return printOrderFinalData
                (name, surname, email,
                        city, address, zip,
                        startDate, expireDate,
                        dietName, kcal, prize,
                        typeOfPayment, phoneNumber);
    }




    private String printOrderFinalData(String name,
                                       String surname,
                                       String email,
                                       String city,
                                       String address,
                                       String zip,
                                       LocalDate startDate,
                                       LocalDate expireDate,
                                       String dietName,
                                       String kcal,
                                       Double prize,
                                       String typeOfPayment,
                                       Long phoneNumber) {
        return "<h1>Order info</h1>" +
                "<a href=\"/login\">Login</a>\n" +
                "<a href=\"/localizations\">Localizations</a>\n" +
                "<a href=\"/diets\">Diets</a>\n" +
                "<a href=\"/price-list\">Price list</a>\n" +
                "<a href=\"/contact\">Contact</a>" +
                "<table>" +
                "<tr><td>name: " + name +
                "</td></tr><tr><td>" + "surname: " + surname +
                "</td></tr><tr><td>" + "email: " + email +
                "</td></tr><tr><td>" + "city: " + city +
                "</td></tr><tr><td>" + "address: " + address +
                "</td></tr><tr><td>" + "zip: " + zip +
                "</td></tr><tr><td>" + "phone number: " + phoneNumber +
                "</td></tr><tr><td>" + "Start date: " + startDate +
                "</td></tr><tr><td>" + "Expire date: " + expireDate +
                "</td></tr><tr><td>" + "Diet name: " + dietName +
                "</td></tr><tr><td>" + "Kcal: " + kcal +
                "</td></tr><tr><td>" + "prize: " + prize +
                "</td></tr><tr><td>Type of payment: " + typeOfPayment + "</td></tr>";
    }
}
