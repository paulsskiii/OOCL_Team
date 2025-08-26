package com.example.day15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderRepository;
import com.example.day15.model.Order;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        order.setStatus("CONFIRMED");
        orderRepository.save(order);
        return order;
    }

    public Object processPayment() {
        throw new UnsupportedOperationException("Unimplemented method 'processPayment'");
    }
}
