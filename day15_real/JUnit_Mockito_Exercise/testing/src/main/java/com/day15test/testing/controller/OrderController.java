package com.day15test.testing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/orders")
public class OrderController {
    @PostMapping
    public ResponseEntity<Order> addOrder (@RequestBody Order order) {
        
    }
}
