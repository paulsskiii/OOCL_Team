package com.example.testexercise.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.testexercise.model.Order;
import com.example.testexercise.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }
}
