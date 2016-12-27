package io.softwarestrategies.kafkatemplate.consumer;

import io.softwarestrategies.kafkatemplate.consumer.data.KafkaConsumerProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(KafkaConsumerProperties.class)
public class KafkaTemplateConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaTemplateConsumerApp.class, args);
    }
}
