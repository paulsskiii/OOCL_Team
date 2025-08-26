package com.day15test.mock.service;

import org.springframework.stereotype.Service;
import com.day15test.mock.model.Order;

@Service
public class OrderService {

    public Order createOrder(Order order) {
        order.setStatus("CONFIRMED");
        return order;
    }

    public String processPayment(Order order) {
        return "SUCCESS";
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'processPayment'");
    }
    

}
