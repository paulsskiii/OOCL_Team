package com.example.excer2;

import java.time.Instant;
import java.util.Properties;
import com.example.excer2.model.Container;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

@Service
public class ContainerProducer{

    public void ContainerProducerMessage () { }

    public void sendMessage (String action, Container container) {

        Properties props = new Properties(); 
        props.put("bootstrap.servers", "localhost:9092"); 
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
 
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) { 
            String cargoNumber = container.getContainerNumber(); 
            String origin = container.getOrigin(); 
            String destination = container.getDestination();
            double weightKg = container.getWeightKg();

            String message = String.format("{\"action:\":\"%s\",\"cargo_number\":\"%s\", \"origin\":\"%s\", \"destination\":\"%s\",\"weightKg\":\"%.2f%n\", \"timestamp\":\"%s\"}",  
                action, cargoNumber, origin, destination, weightKg, Instant.now().toString()); 

            // ProducerRecord with topic, key, and value 
            ProducerRecord<String, String> record = new ProducerRecord<>("container-events", cargoNumber, message); 

            producer.send(record, (metadata, exception) -> { 
                if (exception == null) { 
                    System.out.printf("Sent record to topic %s, partition %d, offset %d%n", 
                            metadata.topic(), metadata.partition(), metadata.offset()); 
                } else { 
                    exception.printStackTrace(); 
                } 
            }); 
            producer.flush(); // Ensure all messages are sent before closing 
        } 
    } 
}
 