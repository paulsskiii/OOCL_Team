package com.capstone.cargo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.capstone.cargo.model.Container;

@Service
public class KafkaConsumer {
    
    private static final String TOPIC = "cargo-events";

    @KafkaListener(topics = TOPIC, groupId = "cargo-group")
    public void listen(Container container, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println("Received a message from partition: " + partition + " : " + container);
    }
}
