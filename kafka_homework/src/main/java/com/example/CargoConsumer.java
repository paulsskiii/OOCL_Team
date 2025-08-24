package com.example;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord; 
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
 
public class CargoConsumer { 
    public static void main(String[] args) throws InterruptedException { 
        Properties props = new Properties(); 
        props.put("bootstrap.servers", "localhost:9092"); 
        props.put("group.id", "tracking-service-group"); 
        props.put("key.deserializer", StringDeserializer.class.getName()); 
        props.put("value.deserializer", StringDeserializer.class.getName()); 
        // props.put("auto.offset.reset", "earliest");     // checks earliest message in the queue
        // try smallest if earliest doesn't work  ^^
        // props.put("partition.assignment.strategy", "roundrobin");   // partition assignment | if many instances, roundrobin approach of assigning consumer
        // https://medium.com/streamthoughts/understanding-kafka-partition-assignment-strategies-and-how-to-write-your-own-custom-assignor-ebeda1fc06f3

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) { 
            consumer.subscribe(Collections.singletonList("cargo-events-partitions")); 
            System.out.println("Tracking service is listening for cargo events..."); 
 
            while (true) { 
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500)); // event handling, checks for new records
                for (ConsumerRecord<String, String> record : records) { 
                    System.out.printf("Received message: key = %s, value = %s, partition = %d, offset = %d%n", 
                            record.key(), record.value(), record.partition(), record.offset()); 
                    Thread.sleep(250);
                } 
            } 
        } 
    } 
} 
 