package com.capstone.cargo.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capstone.cargo.model.Container;

@Service
public class MessagingService {
    private final KafkaTemplate<String, Container> kafkaTemplate;
    private static final String TOPIC_NAME = "container-events";

    public MessagingService(KafkaTemplate<String, Container> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendContainer(Container container) {
        kafkaTemplate.send(TOPIC_NAME, container);
        System.out.println("Produced container: " + container);
    }
}
