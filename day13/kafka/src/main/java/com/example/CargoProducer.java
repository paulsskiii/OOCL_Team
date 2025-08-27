package com.example;

import org.apache.kafka.clients.producer.*; 
import java.util.Properties; 
import java.time.Instant; 
 
public class CargoProducer { 
    public static void main(String[] args) { 
        Properties props = new Properties(); 
        props.put("bootstrap.servers", "localhost:9092"); 
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
 
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) { 
            for (int i = 0; i < 5; i++) { 
                String status = "IN_TRANSIT-" + i;

                String cargoId1 = "C-101";
                String message1 = String.format("{\"cargo_id\":\"%s\", \"status\":\"%s\", \"timestamp\":\"%s\"}",  
                    cargoId1, status, Instant.now().toString());
 
                // ProducerRecord with topic, key, and value 
                ProducerRecord<String, String> record1 = new ProducerRecord<>("cargo-events", cargoId1, message1); 
 
                producer.send(record1, (metadata, exception) -> { 
                    if (exception == null) { 
                        System.out.printf("Sent record to topic %s, partition %d, offset %d%n", 
                                metadata.topic(), metadata.partition(), metadata.offset()); 
                    } else { 
                        exception.printStackTrace(); 
                    } 
                });

                String cargoId2 = "C-101";
                String message2 = String.format("{\"cargo_id\":\"%s\", \"status\":\"%s\", \"timestamp\":\"%s\"}",  
                    cargoId1, status, Instant.now().toString());
 
                // ProducerRecord with topic, key, and value 
                ProducerRecord<String, String> record2 = new ProducerRecord<>("cargo-events", cargoId2, message2); 
 
                producer.send(record2, (metadata, exception) -> { 
                    if (exception == null) { 
                        System.out.printf("Sent record to topic %s, partition %d, offset %d%n", 
                                metadata.topic(), metadata.partition(), metadata.offset()); 
                    } else { 
                        exception.printStackTrace(); 
                    } 
                });

                String cargoId3 = "C-101";
                String message3 = String.format("{\"cargo_id\":\"%s\", \"status\":\"%s\", \"timestamp\":\"%s\"}",  
                    cargoId1, status, Instant.now().toString());
 
                // ProducerRecord with topic, key, and value 
                ProducerRecord<String, String> record3 = new ProducerRecord<>("cargo-events", cargoId3, message3); 
 
                producer.send(record3, (metadata, exception) -> { 
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