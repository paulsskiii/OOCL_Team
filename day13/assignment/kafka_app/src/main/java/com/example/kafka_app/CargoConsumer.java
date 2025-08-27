package com.example.kafka_app;

import org.apache.kafka.clients.consumer.*; 
import org.apache.kafka.common.serialization.StringDeserializer; 
import java.time.Duration; 
import java.util.Collections; 
import java.util.Properties; 
 
public class CargoConsumer { 
    public static void main(String[] args) { 
        Properties props = new Properties(); 
        props.put("bootstrap.servers", "localhost:9092"); 
        props.put("group.id", "tracking-service-group"); 
        props.put("key.deserializer", StringDeserializer.class.getName()); 
        props.put("value.deserializer", StringDeserializer.class.getName()); 
        props.put("auto.offset.reset", "earliest"); 
 
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) { 
            consumer.subscribe(Collections.singletonList("cargo-events")); 
            System.out.println("Tracking service is listening for cargo events..."); 
 
            while (true) { 
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100)); 
                for (ConsumerRecord<String, String> record : records) { 
                    System.out.printf("Received message: key = %s, value = %s, partition = %d, offset = %d%n", 
                            record.key(), record.value(), record.partition(), record.offset()); 
                } 
            } 
        } 
    } 
} 
 