package com.example.day12miniproject.service;

import org.apache.kafka.clients.consumer.*; 
import org.apache.kafka.common.serialization.StringDeserializer; 
import org.springframework.stereotype.Service;
import java.time.Duration; 
import java.util.Collections; 
import java.util.Properties; 

@Service
public class CargoConsumer { 
    
    @jakarta.annotation.PostConstruct
    public void startListening() {
        new Thread(this::consumeMessages).start();
    }
    
    private void consumeMessages() {
        Properties props = new Properties(); 
        props.put("bootstrap.servers", "localhost:9092"); 
        props.put("group.id", "tracking-service-group"); 
        props.put("key.deserializer", StringDeserializer.class.getName()); 
        props.put("value.deserializer", StringDeserializer.class.getName()); 
        props.put("auto.offset.reset", "earliest");
        props.put("session.timeout.ms", 30000);
        props.put("heartbeat.interval.ms", 10000);
 
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) { 
            consumer.subscribe(Collections.singletonList("cargo-events")); 
            System.out.println("Cargo tracking service is listening for cargo events on topic 'cargo-events'..."); 
 
            while (true) { 
                try {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000)); 
                    for (ConsumerRecord<String, String> record : records) { 
                        System.out.printf("🚢 Cargo Event Received: CargoId=%s, Message=%s, Partition=%d, Offset=%d%n", 
                                record.key(), record.value(), record.partition(), record.offset()); 
                        
                        // Here you could add logic to process the cargo event
                        // For example, update container tracking status, notify other services, etc.
                    }
                } catch (Exception e) {
                    System.err.println("Error processing cargo events: " + e.getMessage());
                    e.printStackTrace();
                    // Add a small delay before retrying
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            } 
        } catch (Exception e) {
            System.err.println("Fatal error in cargo consumer: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
