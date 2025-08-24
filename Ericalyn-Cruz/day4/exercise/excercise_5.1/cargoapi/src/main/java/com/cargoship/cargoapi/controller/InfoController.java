package com.cargoship.cargoapi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo() {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format as "yyyy-MM-dd HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // Return formatted string
        return "Current date and time: " + formattedDateTime;
    }
}
