package com.example.kafka_app;

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
                String status = "IN_TRANSIT";
                String timestamp = Instant.now().toString();
                ProducerRecord<String, String> record1 = new ProducerRecord<>(
                        "cargo-events", "C-101",
                        String.format("{\"cargo_id\":\"C-101\", \"status\":\"%s\", \"timestamp\":\"%s\"}", status, timestamp)
                );
                ProducerRecord<String, String> record2 = new ProducerRecord<>(
                        "cargo-events", "C-102",
                        String.format("{\"cargo_id\":\"C-102\", \"status\":\"%s\", \"timestamp\":\"%s\"}", status, timestamp)
                );
                producer.send(record1);
                producer.send(record2);
            producer.flush();
        }
    }
}