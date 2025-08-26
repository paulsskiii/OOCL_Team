package com.capstone.cargo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.capstone.cargo.model.Container;

@Component
public class KafkaListeners {

    @KafkaListener(
        topics = "container-events",
        groupId = "tracking",
        containerFactory = "containerFactory"
    )
    void listener(Container container) {
        System.out.println("Container received: " + container);
    }
}
