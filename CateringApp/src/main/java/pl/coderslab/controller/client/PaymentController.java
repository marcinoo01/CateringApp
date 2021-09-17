package pl.coderslab.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.City;
import pl.coderslab.model.Client;
import pl.coderslab.model.Diet;
import pl.coderslab.model.Order;
import pl.coderslab.repository.DietRepository;
import pl.coderslab.service.ClientService;
import pl.coderslab.service.DietService;
import pl.coderslab.service.OrderService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class PaymentController {

    private final ClientService clientService;
    private final OrderService orderService;
    private final DietService dietService;
    private final DietRepository dietRepository;

    public PaymentController(ClientService clientService, OrderService orderService, DietService dietService, DietRepository dietRepository) {
        this.clientService = clientService;
        this.dietService = dietService;
        this.orderService = orderService;
        this.dietRepository = dietRepository;
    }


    @GetMapping("/payment")
    public String payment() {
        return "form/payment";
    }

    @PostMapping("/payment")
    @ResponseBody
    public String payment(@RequestParam String typeOfPayment, HttpSession session) {
        Diet diet = (Diet) session.getAttribute("diet");
        String kcal = (String) session.getAttribute("kcal");
        LocalDate startDate = (LocalDate) session.getAttribute("startDate");
        LocalDate expireDate = (LocalDate) session.getAttribute("expireDate");
        Double prize = (Double) session.getAttribute("prize");
        String address = (String) session.getAttribute("address");
        String email = (String) session.getAttribute("email");
        String surname = (String) session.getAttribute("surname");
        String zip = (String) session.getAttribute("zip");
        City city = (City) session.getAttribute("city");
        String name = (String) session.getAttribute("name");
        String description = (String) session.getAttribute("description");
        Long phoneNumber = (Long) session.getAttribute("phoneNumber");
        Order order = new Order.Builder()
                .startDate(startDate)
                .expireDate(expireDate)
                .kcal(kcal)
                .lengthWholePlan()
                .totalPrice(prize)
                .diet(diet)
                .build();
        Client client = new Client.Builder().name(name)
                .surname(surname)
                .email(email)
                .address(address)
                .diet(diet)
                .zip(zip)
                .phoneNumber(phoneNumber)
                .city(city)
                .order(order)
                .description(description)
                .build();
        Diet diet1 = dietService.findByDietName(diet.getName());
        diet1.add(client);
        Long amount = diet1.getTotalAmountOfAcquirer();
        if (amount == null) {
            amount = 0L;
        }
        amount++;
        dietRepository.updateAmountOfAcquirer(diet1.getId(), amount);
        dietRepository.save(diet1);
        orderService.add(order);
        clientService.add(client);
        return printOrderFinalData
                (name, surname, email,
                        city, address, zip,
                        startDate, expireDate,
                        diet, kcal, prize,
                        typeOfPayment, phoneNumber);
    }


    private String printOrderFinalData(String name,
                                       String surname,
                                       String email,
                                       City city,
                                       String address,
                                       String zip,
                                       LocalDate startDate,
                                       LocalDate expireDate,
                                       Diet dietName,
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
                "</td></tr><tr><td>" + "city: " + city.getCityName() +
                "</td></tr><tr><td>" + "address: " + address +
                "</td></tr><tr><td>" + "zip: " + zip +
                "</td></tr><tr><td>" + "phone number: " + phoneNumber +
                "</td></tr><tr><td>" + "Start date: " + startDate +
                "</td></tr><tr><td>" + "Expire date: " + expireDate +
                "</td></tr><tr><td>" + "Diet name: " + dietName.getName() +
                "</td></tr><tr><td>" + "Kcal: " + kcal +
                "</td></tr><tr><td>" + "prize: " + prize +
                "</td></tr><tr><td>Type of payment: " + typeOfPayment + "</td></tr>";
    }
}
