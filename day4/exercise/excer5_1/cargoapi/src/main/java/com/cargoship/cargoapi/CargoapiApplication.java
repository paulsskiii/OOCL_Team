package com.cargoship.cargoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cargoship.cargoapi.component.PortAvailabilityChecker;

@SpringBootApplication
public class CargoapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CargoapiApplication.class, args);
    }

}
