package com.collagethis.processresource.service;

import com.collagethis.common.data.ProcessResourceRequest;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

public interface ProcessResourceListenerService {
    void onReceiving(ProcessResourceRequest processResourceRequest, @Header(KafkaHeaders.OFFSET) Integer offset,
                     @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                     @Header(KafkaHeaders.RECEIVED_TOPIC) String topic);
}
