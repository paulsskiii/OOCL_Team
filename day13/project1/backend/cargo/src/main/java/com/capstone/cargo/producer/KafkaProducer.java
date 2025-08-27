package com.capstone.cargo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capstone.cargo.model.Container;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Container> kafkaTemplate;
    private static final String TOPIC = "cargo-events";

    public void sendMessage(Container container) {
        kafkaTemplate.send(TOPIC, String.valueOf(container.getId()), container).whenComplete((result, e) -> {
            if (e == null) {
                System.out.println("Message sent: " + container + " | partition=" + result.getRecordMetadata().partition() + " offset=" + result.getRecordMetadata().offset());
            } else {
                e.printStackTrace();
            }
        });
    }
}


