// EurekaServerApplication.java

// src/main/java/com/example/eurekaserver/EurekaServerApplication.java
package com.example.eureka.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer; // Important annotation

@SpringBootApplication
@EnableEurekaServer // Activates the Eureka Server functionality
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
