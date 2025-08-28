package com.example.demo;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.protocol.types.Field.Str;

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

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 5; i++) {
                List<String> cargoId = new ArrayList<>();
                cargoId.add("C-101");
                cargoId.add("C-102");

                String status = "IN_TRANSIT-" + i;
                String message = String.format("{\"cargo_id\":\"%s\", \"status\":\"%s\", \"timestamp\":\"%s\"}",
                        cargoId, status, Instant.now().toString());

                // ProducerRecord with topic, key, and value
                for (String cargoIds : cargoId) {
                    ProducerRecord<String, String> record = new ProducerRecord<>("cargo-events", cargoIds,
                            message);
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