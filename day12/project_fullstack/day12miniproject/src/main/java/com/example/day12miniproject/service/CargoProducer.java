package com.example.day12miniproject.service;

import org.apache.kafka.clients.producer.*; 
import org.springframework.stereotype.Service;
import java.util.Properties; 
import java.time.Instant; 

@Service
public class CargoProducer { 
    private final KafkaProducer<String, String> producer;
    
    public CargoProducer() {
        Properties props = new Properties(); 
        props.put("bootstrap.servers", "localhost:9092"); 
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
        // Add retries and timeout configurations
        props.put("retries", 3);
        props.put("request.timeout.ms", 30000);
        props.put("delivery.timeout.ms", 60000);
        this.producer = new KafkaProducer<>(props);
    }
    
    public void sendCargoEvent(String cargoId, String status) {
        try {
            String message = String.format("{\"cargo_id\":\"%s\", \"status\":\"%s\", \"timestamp\":\"%s\"}",  
                cargoId, status, Instant.now().toString()); 
                
            ProducerRecord<String, String> record = new ProducerRecord<>("cargo-events", cargoId, message); 
            
            producer.send(record, (metadata, exception) -> { 
                if (exception == null) { 
                    System.out.printf("Successfully sent cargo event - Topic: %s, Partition: %d, Offset: %d, CargoId: %s, Status: %s%n", 
                            metadata.topic(), metadata.partition(), metadata.offset(), cargoId, status); 
                } else { 
                    System.err.printf("Failed to send cargo event for CargoId: %s, Status: %s - Error: %s%n", 
                            cargoId, status, exception.getMessage());
                    exception.printStackTrace(); 
                } 
            });
        } catch (Exception e) {
            System.err.printf("Exception while sending cargo event for CargoId: %s, Status: %s - Error: %s%n", 
                    cargoId, status, e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void close() {
        if (producer != null) {
            producer.close();
        }
    }
}

