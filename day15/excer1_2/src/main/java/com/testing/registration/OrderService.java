package day15.excer1_2.src.main.java.com.testing.registration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(WebClient.Builder builder, OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        order.setStatus("CONFIRMED");
        return orderRepository.save(order);  // save to DB
    }

    public String processPayment(Order order) {
        return "SUCCESS";
    }
}


