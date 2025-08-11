package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    // Spring will automatically inject the CoffeeOrderManager here
    @Autowired
    private CoffeeOrderManager orderManager;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // This method is called after the Spring application has started
    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Application is running and calling the CoffeeOrderManager ---");
        orderManager.processOrder("Latte");
    }
}