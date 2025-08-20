package com.example.day12miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service 
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate; 
    private static final String TOPIC_NEW_CONTAINER = "new_container_topic"; 

    public void sendMessage(String message) { 
        kafkaTemplate.send(TOPIC_NEW_CONTAINER, message); 
        System.out.println("Message sent to Kafka: " + message);
    }
}

