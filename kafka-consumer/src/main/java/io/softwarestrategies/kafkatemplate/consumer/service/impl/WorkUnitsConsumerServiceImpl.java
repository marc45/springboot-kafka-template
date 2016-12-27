package io.softwarestrategies.kafkatemplate.consumer.service.impl;

import io.softwarestrategies.kafkatemplate.common.data.WorkUnit;
import io.softwarestrategies.kafkatemplate.consumer.service.WorkUnitsConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class WorkUnitsConsumerServiceImpl implements WorkUnitsConsumerService {
    private static final Logger log = LoggerFactory.getLogger(WorkUnitsConsumerServiceImpl.class);

    @KafkaListener(topics = "workunits")
    public void onReceiving(WorkUnit workUnit, @Header(KafkaHeaders.OFFSET) Integer offset,
                            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("Processing topic = {}, partition = {}, offset = {}, workUnit = {}",
                topic, partition, offset, workUnit);
    }
}
