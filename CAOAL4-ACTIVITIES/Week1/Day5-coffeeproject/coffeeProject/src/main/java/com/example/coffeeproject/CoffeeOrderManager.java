package com.example.coffeeproject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CoffeeOrderManager {

    // This is where Dependency Injection happens via annotation.
    // We're not creating a 'new CoffeeService()'. Instead, we're telling
    // Spring to find an instance of CoffeeService and "autowire" it here.
    @Autowired 
    private CoffeeService coffeeService;

    public void processOrder(String coffeeType) {
        System.out.println("🛒 CoffeeOrderManager: Processing order.");
        this.coffeeService.placeOrder(coffeeType);
    }
}