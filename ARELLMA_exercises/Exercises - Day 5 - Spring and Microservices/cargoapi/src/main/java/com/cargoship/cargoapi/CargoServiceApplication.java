// Main Application Class
    // The entry point for your Spring Boot application
    
// src/main/java/com/example/cargoservice/CargoServiceApplication.java
package com.cargoship.cargoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Marks this as a Spring Boot application
public class CargoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CargoServiceApplication.class, args);
    }
}
