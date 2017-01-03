package com.collagethis.processresource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaProperties {

    private String bootstrap;
    private String group;
    private String topic;
}
