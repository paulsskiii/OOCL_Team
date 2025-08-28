package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Order createOrder(Order order) {
        return order;
    }

    public String processPayment(Order order) {
        return "SUCCESS";
    }
}
