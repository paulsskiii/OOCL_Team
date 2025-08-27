package com.day15test.testing.service;

import org.springframework.stereotype.Service;

import com.day15test.testing.model.Order;

@Service
public class OrderService {

    public Order createOrder(Order order) {
        // Simple implementation - just return the order with a status
        order.setStatus("CONFIRMED");
        return order;
    }

    public String processPayment(Order order) {
        return "SUCCESS";
    }
    
}
