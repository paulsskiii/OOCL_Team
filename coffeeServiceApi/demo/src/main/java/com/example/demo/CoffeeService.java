package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CoffeeService {
    public void placeOrder(String coffeeType) {
        System.out.println("☕️ Spring CoffeeService: Placing order for a " + coffeeType + ".");
    }
}
