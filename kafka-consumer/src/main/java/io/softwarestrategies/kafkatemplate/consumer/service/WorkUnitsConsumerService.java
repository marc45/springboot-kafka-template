package io.softwarestrategies.kafkatemplate.consumer.service;

import io.softwarestrategies.kafkatemplate.common.data.WorkUnit;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

public interface WorkUnitsConsumerService {
    void onReceiving(WorkUnit workUnit, @Header(KafkaHeaders.OFFSET) Integer offset,
                     @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                     @Header(KafkaHeaders.RECEIVED_TOPIC) String topic);
}
