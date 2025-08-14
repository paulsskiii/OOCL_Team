package main.java.com.example.cargo_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${shipping.fee}")
    private double shippingFee;

    @GetMapping("/message")
    public String getMessage() {
        return welcomeMessage + " Shipping Fee: $" + shippingFee;
    }
}