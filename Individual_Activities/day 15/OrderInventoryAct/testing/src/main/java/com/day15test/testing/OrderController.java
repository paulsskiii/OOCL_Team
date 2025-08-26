package com.day15test.testing;

import org.springframework.web.bind.annotation.*;

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
