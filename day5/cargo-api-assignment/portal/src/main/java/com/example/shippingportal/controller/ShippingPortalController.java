package com.example.shippingportal.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping ("/portal")
public class ShippingPortalController {
    private final RestTemplate restTemplate;

    public ShippingPortalController (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/cargo")
    public String getCargo () {
        return restTemplate.getForObject ("http://CARGO-API/cargo", String.class);
    }
    
    
}
