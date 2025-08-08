package com.cargoship.cargoapi.controller;

import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo() {
        //  Get current date and 
        LocalDateTime localDateTime = LocalDateTime.now();
        //  Format it as "yyyy-MM-dd HH:mm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //  Return formatted string like: "Current date and time: 2025-08-07 10:30:00"
        String formattedDate = localDateTime.format(formatter);
        String showDate = "Current date and time: " + formattedDate;
        return showDate; // Replace this
    }
}