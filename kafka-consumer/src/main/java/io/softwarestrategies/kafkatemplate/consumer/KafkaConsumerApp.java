package io.softwarestrategies.kafkatemplate.consumer;

import io.softwarestrategies.kafkatemplate.consumer.config.KafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(KafkaProperties.class)
public class KafkaConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApp.class, args);
    }
}
