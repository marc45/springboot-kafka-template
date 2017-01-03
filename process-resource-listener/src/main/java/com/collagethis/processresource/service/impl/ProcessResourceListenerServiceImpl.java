package com.collagethis.processresource.service.impl;

import com.collagethis.common.data.ProcessResourceRequest;
import com.collagethis.processresource.service.ProcessResourceListenerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class ProcessResourceListenerServiceImpl implements ProcessResourceListenerService {
    private static final Logger log = LoggerFactory.getLogger(ProcessResourceListenerServiceImpl.class);

    // TODO This needs to be read as property
    @KafkaListener(topics = "process-resource-request")
    public void onReceiving(ProcessResourceRequest processResourceRequest,
                            @Header(KafkaHeaders.OFFSET) Integer offset,
                            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("Processing topic = {}, partition = {}, offset = {}, processResourceRequest = {}",
                topic, partition, offset, processResourceRequest);
    }
}
