package io.softwarestrategies.kafkatemplate.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaProperties {
    private String bootstrap;
    private String topic;
}
