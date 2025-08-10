package com.cargoship.cargoapi;

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
    private Double shippingFee;

    @Value("${cargo.default_size}")
    private Double cargoDefaultSize;

    @Value("${eureka.instance.instance-id:unknown}")
    private String instanceId;

    @GetMapping("/instance")
    public String getInstanceId(){
        return " Running Instance ID " + instanceId;
    }

    @GetMapping("/message")
    public String getMessage() {
        return welcomeMessage + " Shipping Fee: $" + shippingFee;
    }

    @GetMapping("/message/size")
    public String getMessageCargoDefaultSize() {
        return welcomeMessage + " Cargo Default Size: " + cargoDefaultSize;
    }
}
