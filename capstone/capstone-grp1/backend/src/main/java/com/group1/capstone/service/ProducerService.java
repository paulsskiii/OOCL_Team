package com.group1.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.group1.capstone.exceptions.CargoNotFoundException;
import com.group1.capstone.exceptions.StatusNotFoundException;
import com.group1.capstone.model.Cargo;
import com.group1.capstone.model.Status;
import com.group1.capstone.model.TrackingEvent;
import com.group1.capstone.model.User;
import com.group1.capstone.repository.CargoRepository;
import com.group1.capstone.repository.StatusRepository;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private StatusRepository statusRepository;

    private static final String CARGO_TOPIC = "cargo-events";
    private static final String USER_TOPIC = "user-events";
    private static final String TE_TOPIC = "tracking-e-events";

    public Message<Cargo> setMessage(Cargo cargo, String action){
        return MessageBuilder
        .withPayload(cargo)
        .setHeader(KafkaHeaders.TOPIC, CARGO_TOPIC)
        .setHeader("action", action) 
        .build();
    }

    public Message<User> setMessage(User user, String action){
        return MessageBuilder
        .withPayload(user)
        .setHeader(KafkaHeaders.TOPIC, USER_TOPIC)
        .setHeader("action", action) 
        .build();
    }

    public Message<TrackingEvent> setMessage(TrackingEvent te, String status, String cargo, String action){
        return MessageBuilder
        .withPayload(te)
        .setHeader(KafkaHeaders.TOPIC, TE_TOPIC)
        .setHeader("action", action) 
        .setHeader("status", status) 
        .setHeader("cargo", cargo) 
        .build();
    }

    public void sendMessage(Cargo cargo, String action) {
        Message<Cargo> message = setMessage(cargo, action);

        kafkaTemplate.send(message).whenComplete((result, e) -> {
            if (e == null) {
                System.out.println("Message sent: " + cargo + " | partition=" + result.getRecordMetadata().partition() + " offset=" + result.getRecordMetadata().offset());
            } else {
                e.printStackTrace();
            }
        });
    }

    public void sendMessage(User user, String action) {
        Message<User> message = setMessage(user, action);

        kafkaTemplate.send(message).whenComplete((result, e) -> {
            if (e == null) {
                System.out.println("Message sent: " + user + " | partition=" + result.getRecordMetadata().partition() + " offset=" + result.getRecordMetadata().offset());
            } else {
                e.printStackTrace();
            }
        });
    }
    
    public void sendMessage(TrackingEvent te, String status, String cargo, String action) {
        Message<TrackingEvent> message = setMessage(te,status, cargo ,action);

        kafkaTemplate.send(message).whenComplete((result, e) -> {
            if (e == null) {
                System.out.println("Message sent: " + te + " | partition=" + result.getRecordMetadata().partition() + " offset=" + result.getRecordMetadata().offset());
            } else {
                e.printStackTrace();
            }
        });
    }
}
