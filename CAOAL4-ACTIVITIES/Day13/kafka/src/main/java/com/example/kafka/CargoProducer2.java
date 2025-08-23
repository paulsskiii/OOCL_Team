// ACTIVITY 2ND
package com.example.kafka;

import java.time.Instant;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
 
public class CargoProducer2 { 
    public static void main(String[] args) { 
        Properties props = new Properties(); 
        props.put("bootstrap.servers", "localhost:9092"); 
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
 
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) { 
            for (int i = 0; i < 5; i++) { 
                String cargoId1 = "C-101"; 
                String cargoId2 = "C-102"; 
                String status1 = "IN_TRANSIT-" + i; 
                String status2 = "DELIVERED-" + i;
                String message1 = String.format("{\"cargo_id\":\"%s\", \"status\":\"%s\", \"timestamp\":\"%s\"}",  
                    cargoId1, status1, Instant.now().toString()); 
                String message2 = String.format("{\"cargo_id\":\"%s\", \"status\":\"%s\", \"timestamp\":\"%s\"}",  
                    cargoId2, status2, Instant.now().toString());
 
                //USE CARGO_ID AS THE KEY
                ProducerRecord<String,String> record1 = new ProducerRecord<>("cargo-events", cargoId1, message1);
                ProducerRecord<String,String> record2 = new ProducerRecord<>("cargo-events", cargoId2, message2);

 
                producer.send(record1, (metadata, exception) -> { 
                    if (exception == null) { 
                        System.out.printf("Sent record to topic %s, partition %d, offset %d%n", 
                                metadata.topic(), metadata.partition(), metadata.offset()); 
                    } else { 
                        exception.printStackTrace(); 
                    } 
                });
                producer.send(record2, (metadata, exception) -> { 
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