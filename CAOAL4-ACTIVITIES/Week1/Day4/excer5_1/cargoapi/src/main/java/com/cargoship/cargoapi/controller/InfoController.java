package com.cargoship.cargoapi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo() {
        // TODO: Get current date and time
        LocalDateTime now = LocalDateTime.now();

        // TODO: Format it as "yyyy-MM-dd HH:mm:ss"
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        // TODO: Return formatted string like: "Current date and time: 2025-08-07 10:30:00"
        return formatDate.format(now); // Replace this
    }
}