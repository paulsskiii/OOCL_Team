package com.group1.capstone.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class TopicsConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return new KafkaAdmin(configs);
    }
    
    @Bean
    public NewTopic topic1() {
        return new NewTopic("cargo-events", 5, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic("user-events", 5, (short) 1);
    }

    @Bean
    public NewTopic topic3() {
        return new NewTopic("tracking-e-events", 5, (short) 1);
    }
}
