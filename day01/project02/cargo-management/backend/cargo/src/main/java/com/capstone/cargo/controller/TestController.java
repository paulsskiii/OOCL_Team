package com.capstone.cargo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/message")
public class TestController {
    // private static final String TEST_TOPIC = "test-topic";

    // private final KafkaTemplate<String, String> kafkaTemplate;

    // public TestController(@Qualifier("kafkaTemplate") KafkaTemplate<String, String> kafkaTemplate) {
    //     this.kafkaTemplate = kafkaTemplate;
    // }

    // @PostMapping("/send-message")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void sendMessage(@RequestBody Container container) {
    //     kafkaTemplate.send(TEST_TOPIC, container.getDestination());
    // }
}
