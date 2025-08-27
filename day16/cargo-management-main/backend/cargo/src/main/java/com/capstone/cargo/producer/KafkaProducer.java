package com.capstone.cargo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capstone.cargo.model.Container;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Container> kafkaTemplate;
    private static final String TOPIC = "container-updates"; 

    public void sendMessage(Container container) { 
        kafkaTemplate.send(TOPIC, container);
        System.out.println("Message sent to Kafka: " + container);
    }
}


