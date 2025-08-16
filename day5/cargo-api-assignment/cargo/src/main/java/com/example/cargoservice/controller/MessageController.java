package com.example.cargoservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/message")
public class MessageController {
    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${shipping_fee}")
    private double shippingFee;

    @GetMapping
    public String getMessage() {
        return welcomeMessage + " Shipping Fee: $" + shippingFee;
    }
}
