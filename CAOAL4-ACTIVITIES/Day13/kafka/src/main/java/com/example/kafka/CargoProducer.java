// ACTIVITY 1ST
package com.example.kafka;

import java.time.Instant;
import java.util.Properties;
 
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
 
public class CargoProducer { 
    public static void main(String[] args) { 
        Properties props = new Properties(); 
        props.put("bootstrap.servers", "localhost:9092"); 
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
 
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) { 
            for (int i = 0; i < 5; i++) { 
                String cargoId = "C-101"; 
                String status = "IN_TRANSIT-" + i; 
                String message = String.format("{\"cargo_id\":\"%s\", \"status\":\"%s\", \"timestamp\":\"%s\"}",  
                    cargoId, status, Instant.now().toString()); 
 
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
            } 
            producer.flush(); // Ensure all messages are sent before closing 
        } 
    } 
}