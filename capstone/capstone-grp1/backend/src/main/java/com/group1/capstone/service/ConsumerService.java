package com.group1.capstone.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.group1.capstone.model.Cargo;
import com.group1.capstone.model.TrackingEvent;
import com.group1.capstone.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {
    private static final String CARGO_TOPIC = "cargo-events";
    private static final String CARGO_GROUP = "cargo-group";
    private static final String USER_TOPIC = "user-events";
    private static final String USER_GROUP = "user-group";
    private static final String TE_TOPIC = "tracking-e-events";
    private static final String TE_GROUP = "tracking-e-group";

    @KafkaListener(topics = CARGO_TOPIC, groupId = CARGO_GROUP)
    public void listen(Cargo cargo, @Header("action") String action) {
        log.info("Received CARGO updates: " + action + " " + cargo.getName());
    }

    @KafkaListener(topics = USER_TOPIC, groupId = USER_GROUP)
    public void listen(User user, @Header("action") String action) {
        log.info("Received USER updates: " + action + " " + user.getFirstName() + " " + user.getLastName());
    }

    @KafkaListener(topics = TE_TOPIC, groupId = TE_GROUP)
    public void listen(
            TrackingEvent trackingEvent,
            @Header("action") String action,
            @Header("status") String status,
            @Header("cargo") String cargo) {
        log.info("Received TRACKING EVENT updates: " + action + " " + cargo + " with status "
                + status);
    }
}