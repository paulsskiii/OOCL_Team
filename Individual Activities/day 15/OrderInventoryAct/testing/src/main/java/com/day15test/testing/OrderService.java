package com.day15test.testing;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Order createOrder(Order order) {
        order.setStatus("CONFIRMED");
        return order;
    }

    public String processPayment(Order order) {
        return "SUCCESS";
    }
    
}
