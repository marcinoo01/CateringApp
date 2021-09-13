package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Client;
import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void add(Order order) {
        orderRepository.save(order);
    }

    public void setOrderRequestedDataToSession(Client client, HttpSession session) {
        session.setAttribute("address", client.getAddress());
        session.setAttribute("email", client.getEmail());
        session.setAttribute("surname", client.getSurname());
        session.setAttribute("zip", client.getZip());
        session.setAttribute("city", client.getCityName());
        session.setAttribute("name", client.getName());
        session.setAttribute("phoneNumber", client.getPhoneNumber());
    }


}
