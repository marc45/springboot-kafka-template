package com.collagethis.api.config;

import com.collagethis.common.data.ProcessResourceRequest;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    private KafkaProperties kafkaProperties;

    @Autowired
    public KafkaConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public ProducerFactory<String, ProcessResourceRequest> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs(), stringKeySerializer(), processResourceRequestJsonSerializer());
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrap());
        return props;
    }

    @Bean
    public KafkaTemplate<String, ProcessResourceRequest> processResourceRequestKafkaTemplate() {
        KafkaTemplate<String, ProcessResourceRequest> kafkaTemplate =  new KafkaTemplate<>(producerFactory());
        kafkaTemplate.setDefaultTopic(kafkaProperties.getTopic());
        return kafkaTemplate;
    }

    @Bean
    public Serializer stringKeySerializer() {
        return new StringSerializer();
    }

    @Bean
    public Serializer processResourceRequestJsonSerializer() {
        return new JsonSerializer();
    }
}
