package pl.coderslab.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.*;
import pl.coderslab.repository.DietRepository;
import pl.coderslab.repository.OrderRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.ClientService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class PaymentUserController {

    private final UserRepository userRepository;
    private final ClientService clientService;
    private final OrderRepository orderRepository;
    private final DietRepository dietRepository;

    public PaymentUserController(UserRepository userRepository, ClientService clientService, OrderRepository orderRepository, DietRepository dietRepository) {
        this.userRepository = userRepository;
        this.clientService = clientService;
        this.orderRepository = orderRepository;
        this.dietRepository = dietRepository;
    }

    @GetMapping("/user/payment")
    public String payment() {
        return "user/payment";
    }


    @PostMapping("/user/payment")
    public String paymentUser(@RequestParam String typeOfPayment, Model model, HttpSession session) {
        Long idUser = (Long) session.getAttribute("idUser");
        User user = userRepository.getById(idUser);
        String email = userRepository.findById(idUser).get().getEmail();
        City city1 = (City) session.getAttribute("city");
        model.addAttribute("diet", session.getAttribute("diet"));
        model.addAttribute("kcal", session.getAttribute("kcal"));
        model.addAttribute("startDate", session.getAttribute("startDate"));
        model.addAttribute("expireDate", session.getAttribute("expireDate"));
        model.addAttribute("prize", session.getAttribute("prize"));
        model.addAttribute("address", session.getAttribute("address"));
        model.addAttribute("email", email);
        model.addAttribute("surname", session.getAttribute("surname"));
        model.addAttribute("zip", session.getAttribute("zip"));
        model.addAttribute("city", city1.getCityName());
        model.addAttribute("name", session.getAttribute("name"));
        model.addAttribute("phoneNumber", session.getAttribute("phoneNumber"));
        model.addAttribute("typeOfPayment", typeOfPayment);
        model.addAttribute("description", session.getAttribute("description"));
        Diet diet = (Diet) session.getAttribute("diet");
        Client client = new Client.Builder().name((String) session.getAttribute("name"))
                .surname((String) session.getAttribute("surname"))
                .email(email)
                .address((String) session.getAttribute("address"))
                .zip((String) session.getAttribute("zip"))
                .phoneNumber((Long) session.getAttribute("phoneNumber"))
                .user(user)
                .city(city1)
                .diet((Diet) session.getAttribute("diet"))
                .description((String) session.getAttribute("description"))
                .build();
        Order order = new Order.Builder()
                .startDate((LocalDate) session.getAttribute("startDate"))
                .expireDate((LocalDate) session.getAttribute("expireDate"))
                .lengthWholePlan()
                .totalPrice((Double) session.getAttribute("prize"))
                .kcal((String) session.getAttribute("kcal"))
                .diet(diet)
                .user(user)
                .build();
        user.add(order);
        client.setOrder(order);
        Diet diet1 = dietRepository.findDietByName(((Diet) session.getAttribute("diet")).getName());
        diet1.add(client);
        Long amount = diet.getTotalAmountOfAcquirer();
        if (amount == null) {
            amount = 0L;
        }
        amount++;
        dietRepository.updateAmountOfAcquirer(diet.getId(), amount);
        dietRepository.save(diet1);
        orderRepository.save(order);
        clientService.add(client);
        userRepository.save(user);
        return "user/paymentResult";
    }
}
