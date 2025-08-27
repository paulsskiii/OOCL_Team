package com.capstone.cargo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.capstone.cargo.model.Container;

@Service
public class KafkaConsumer {
    
    private static final String TOPIC = "container-updates";

    @KafkaListener(topics = TOPIC, groupId = "cargo_group")
    public void listen(Container container) {
        System.out.println("Received a message from Kafka: " + container);
    }
}
