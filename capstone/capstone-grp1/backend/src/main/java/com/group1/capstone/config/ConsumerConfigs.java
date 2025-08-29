package com.group1.capstone.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.group1.capstone.model.Cargo;

@EnableKafka
@Configuration
public class ConsumerConfigs {

    // @Value(value = "${spring.kafka.consumer.key-deserializer}")
    // private String keyDeserializer;

    // @Value(value = "${spring.kafka.consumer.value-deserializer}")
    // private String valueDeserializer;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, Cargo> consumerFactory() {
        // JsonDeserializer<Cargo> deserializer = new JsonDeserializer<>(Cargo.class);

        // deserializer.addTrustedPackages("com.group1.capstone.model");

        // deserializer.setRemoveTypeHeaders(false);

        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.group1.capstone.model");
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, Cargo.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Cargo> kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, Cargo> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
