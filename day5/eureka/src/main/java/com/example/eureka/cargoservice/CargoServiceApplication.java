// Modify CargoServiceApplication.java to use the Configured Property

// src/main/java/com/example/cargoservice/CargoServiceApplication.java
package com.example.eureka.cargoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope; // For dynamic refresh
import org.springframework.beans.factory.annotation.Value; // For injecting properties
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CargoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CargoServiceApplication.class, args);
    }
}

// A new controller to demonstrate fetching properties from Config Server
@RefreshScope // Allows configuration to be refreshed at runtime via /actuator/refresh
@RestController
class ConfigClientController {
    @Value("${welcome.message}") // Injecting the property from Config Server
    private String welcomeMessage;

    @Value("${shipping.fee}")
    private double shippingFee;

    @GetMapping("/config-info")
    public String getConfigInfo() {
        return "Configured Welcome Message: " + welcomeMessage +
               "<br>Configured Shipping Fee: $" + String.format("%.2f", shippingFee);
    }
}
