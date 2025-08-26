// ConfigServerApplication.java

// src/main/java/com/example/configserver/ConfigServerApplication.java
package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer; // Important annotation

@SpringBootApplication
@EnableConfigServer // Activates the Config Server functionality
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
