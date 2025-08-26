// Modify CargoServiceApplication.java
    //Add @EnableDiscoveryClient to the main application class.

// src/main/java/com/example/cargoservice/CargoServiceApplication.java
package com.example.cargoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // Important annotation

// ... other imports ...

@SpringBootApplication
@EnableDiscoveryClient // Activates this application as a Eureka Client
public class CargoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CargoServiceApplication.class, args);
    }
}

