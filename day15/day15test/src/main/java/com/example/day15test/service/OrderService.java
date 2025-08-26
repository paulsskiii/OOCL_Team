package com.example.day15test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day15test.model.Order;
import com.example.day15test.repository.OrderRepository;

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
