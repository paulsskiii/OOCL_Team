package com.example.day12miniproject;


import org.apache.kafka.clients.producer.*;

import com.example.day12miniproject.model.Container;

import java.util.Properties; 
import java.time.Instant; 
 
public class ContainerProducer { 
    
    public void addContainer(Container container) { 
        Properties props = new Properties(); 
        props.put("bootstrap.servers", "localhost:9092"); 
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
 
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) { 
            
            String cargoId = "CARGO MINIPROJECT g2w3"; 
            String message = String.format("{\"containerName\":\"%s\", \"weight\":\"%s\", \"origin\":\"%s\", \"destination\":\"%s\"}",  
                container.getContainerName(), container.getWeight(), container.getOrigin(), container.getDestination()); 

            // ProducerRecord with topic, key, and value 
            ProducerRecord<String, String> record = new ProducerRecord<>("cargo-events", cargoId, message); 

            producer.send(record, (metadata, exception) -> { 
                if (exception == null) { 
                    System.out.printf("Sent record to topic %s, partition %d, offset %d%n", 
                            metadata.topic(), metadata.partition(), metadata.offset()); 
                } else { 
                    exception.printStackTrace(); 
                } 
            }); 
            
            producer.flush(); // Ensure all messages are sent before closing 
        } 
    } 
}