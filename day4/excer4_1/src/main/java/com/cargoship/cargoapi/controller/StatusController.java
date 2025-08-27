package com.cargoship.cargoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling status check requests.
 */
@RestController
public class StatusController {

    @GetMapping("/status")
    public String getStatus() {
        // TODO: Return a message that confirms the API is running
        return null; // Replace this
    }
}