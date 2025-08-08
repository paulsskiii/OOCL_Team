package com.cargoship.cargoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo() {
        // Get current date and time

        // Format it (yyyy-MM-dd HH:mm:ss)

        // Return formatted date and time as a string
        return null; // replace this
    }
}