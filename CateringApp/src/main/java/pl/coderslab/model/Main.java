package pl.coderslab.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDateTime.now().toLocalDate();
        System.out.println(localDate);
        Client client = new Client();
        Order order = new Order();
        order.setStartDate(LocalDate.now());
        order.calculateExpireDateAndLength(order.getStartDate(), 362);
        System.out.println(order);
    }
}
