package com.cargoship.cargoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cargoship.cargoapi.service.ShipService;

/**
 * Controller for handling status check requests.
 */
@RestController
public class StatusController {
    @Autowired
    private ShipService service;

    @GetMapping("/status")
    public String getStatus() {
        // TODO: Return a message that confirms the API is running
        return "Api is Running"; // Replace this
    }
}