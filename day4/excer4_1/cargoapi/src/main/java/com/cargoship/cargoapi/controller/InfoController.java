package com.cargoship.cargoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo() {
        // Get current date and time
        LocalDateTime currDateTime = LocalDateTime.now();

        // Format it (yyyy-MM-dd HH:mm:ss)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Return formatted date and time as a string
        return formatter.format(currDateTime);
    }
}