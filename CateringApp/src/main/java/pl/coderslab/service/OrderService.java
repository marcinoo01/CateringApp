package pl.coderslab.service;

import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(Long id){
        return orderRepository.findAll();
    }

    public void add(Order order){
        orderRepository.save(order);
    }

}
