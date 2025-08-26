package com.day15test.testing;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Order createOrder(Order order) {
        // Simple implementation - just return the order with a status
        order.setStatus("CONFIRMED");
        return order;
    }

    public String processPayment(Order order) {
        return "SUCCESS";

        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'processPayment'");
    }
    
}
