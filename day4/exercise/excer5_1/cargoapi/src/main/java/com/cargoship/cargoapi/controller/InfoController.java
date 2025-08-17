package com.cargoship.cargoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cargoship.cargoapi.service.ShipService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo() {
        // TODO: Get current date and time
        LocalDateTime now = LocalDateTime.now();

        // TODO: Format it as "yyyy-MM-dd HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // TODO: Return formatted string like: "Current date and time: 2025-08-07 10:30:00"
        return "Current date and time: " + formattedDateTime;
    }
}