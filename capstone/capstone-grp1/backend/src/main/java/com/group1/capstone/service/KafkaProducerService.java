package com.group1.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.group1.capstone.model.Cargo;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Cargo> kafkaTemplate;
    private static final String TOPIC = "cargo-events";

    public void sendMessage(Cargo cargo) {

        kafkaTemplate.send(TOPIC, String.valueOf(cargo.getId()), cargo).whenComplete((result, e) -> {
            if (e == null) {
                System.out.println("Message sent: " + cargo + " | partition=" + result.getRecordMetadata().partition() + " offset=" + result.getRecordMetadata().offset());
            } else {
                e.printStackTrace();
            }
        });
    }
}
