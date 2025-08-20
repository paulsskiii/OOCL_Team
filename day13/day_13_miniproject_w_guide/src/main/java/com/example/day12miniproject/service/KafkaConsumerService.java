package com.example.day12miniproject.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.day12miniproject.repository.ContainerRepository;

@Service
public class KafkaConsumerService {

    @Autowired
    private final ContainerRepository containerRepository;
    private static final String TOPIC_NEW_CONTAINER = "new_container_topic";

    public KafkaConsumerService(ContainerRepository containerRepository){
        this.containerRepository = containerRepository;

    }

    @KafkaListener(topics = TOPIC_NEW_CONTAINER, groupId = "cargo_group")
    public void listen(String message) { 
        System.out.println("Received a message from Kafka: " + message);
    }
}
