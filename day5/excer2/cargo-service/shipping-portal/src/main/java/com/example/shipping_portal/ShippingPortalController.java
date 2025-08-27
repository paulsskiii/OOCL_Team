package com.example.shipping_portal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShippingPortalController {
    private final RestTemplate restTemplate;

    public ShippingPortalController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/portal/cargo")
    public String getCargo() {
        return restTemplate.getForObject("http://CARGO-SERVICE/cargo", String.class);
    }
}