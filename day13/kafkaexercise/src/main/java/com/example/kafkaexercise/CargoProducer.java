package com.example.kafkaexercise;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties; 
import java.time.Instant; 
 
public class CargoProducer { 
    public static void main(String[] args) { 
        Properties props = new Properties(); 
        props.put("bootstrap.servers", "localhost:9092"); 
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
        
        List<String> cargoIdList = new ArrayList<>();
        cargoIdList.add("C-101"); 
        cargoIdList.add("C-102"); 
 
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) { 
            for (int i = 0; i < 5; i++) { 
                String status = "IN_TRANSIT-" + i; 
            
                // ProducerRecord with topic, key, and value 
                for(String cargoId : cargoIdList) {
                    String message = String.format("{\"cargo_id\":\"%s\", \"status\":\"%s\", \"timestamp\":\"%s\"}",  
                    cargoId, status, Instant.now().toString()); 
                    ProducerRecord<String, String> record = new ProducerRecord<>("cargo-events", cargoId, message); 

                    producer.send(record, (metadata, exception) -> { 
                        if (exception == null) { 
                            System.out.printf("Sent record to topic %s, partition %d, offset %d%n", 
                                    metadata.topic(), metadata.partition(), metadata.offset()); 
                        } else { 
                            exception.printStackTrace(); 
                        } 
                    }); 
                }
            } 
            producer.flush(); // Ensure all messages are sent before closing 
        } 
    } 
}