package com.day15test.testing.controller;

import org.springframework.web.bind.annotation.*;

import com.day15test.testing.model.Order;
import com.day15test.testing.service.OrderService;

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
