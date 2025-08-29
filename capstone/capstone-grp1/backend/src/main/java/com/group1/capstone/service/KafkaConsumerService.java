package com.group1.capstone.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.group1.capstone.model.Cargo;

@Service
public class KafkaConsumerService {
    private static final String TOPIC = "cargo-events";

    @KafkaListener(topics = TOPIC, groupId = "cargo-group")
    public void listen(Cargo cargo, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println("Received a message from partition: " + partition + " : " + cargo);
    }
}
