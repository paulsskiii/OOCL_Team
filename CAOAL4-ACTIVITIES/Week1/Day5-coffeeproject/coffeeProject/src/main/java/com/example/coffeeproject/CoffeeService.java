package com.example.coffeeproject;
import org.springframework.stereotype.Service;


@Service
class CoffeeService {
    public void placeOrder(String coffeeType) {
        System.out.println("☕️ Spring CoffeeService: Placing order for a " + coffeeType + ".");
    }
}
