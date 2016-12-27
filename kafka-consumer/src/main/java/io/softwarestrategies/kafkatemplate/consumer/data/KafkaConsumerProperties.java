package io.softwarestrategies.kafkatemplate.consumer.data;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kafka.consumer")
@Data
public class KafkaConsumerProperties {

    private String bootstrap;
    private String group;
    private String topic;
}
