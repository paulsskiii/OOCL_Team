package com.excercise2.springtest;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    public Order createOrder(Order any) {
        // TODO Auto-generated method stub
        return any;
    }

    public String processPayment(Order order) {
        // TODO Auto-generated method stub
        return "SUCCESS";
    }

}
