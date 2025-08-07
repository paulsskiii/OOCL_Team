package com.cargoship.cargoapi.controller;

import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo() {
        // Get current date and time
        LocalDateTime localDateTime = LocalDateTime.now();
        // Format it (yyyy-MM-dd HH:mm:ss)
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fdt = localDateTime.format(dt);
        // Return formatted date and time as a string
        
        return fdt; // replace this
    }
}