package com.collagethis.processresource;

import com.collagethis.processresource.config.KafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(KafkaProperties.class)
public class ProcessResourceListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProcessResourceListenerApplication.class, args);
    }
}
