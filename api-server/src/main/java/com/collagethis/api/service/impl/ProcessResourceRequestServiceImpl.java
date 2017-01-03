package com.collagethis.api.service.impl;

import com.collagethis.api.service.ProcessResourceRequestService;
import com.collagethis.common.data.ProcessResourceRequest;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class ProcessResourceRequestServiceImpl implements ProcessResourceRequestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessResourceRequestService.class);

    private KafkaTemplate<String, ProcessResourceRequest> processResourceRequestKafkaTemplate;

    @Autowired
    public ProcessResourceRequestServiceImpl(KafkaTemplate<String, ProcessResourceRequest> processResourceRequestKafkaTemplate) {
        this.processResourceRequestKafkaTemplate = processResourceRequestKafkaTemplate;
    }

    public boolean dispatch(ProcessResourceRequest processResourceRequest) {
        try {
            SendResult<String, ProcessResourceRequest> sendResult
                    = processResourceRequestKafkaTemplate.sendDefault(processResourceRequest.getId(), processResourceRequest).get();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();
            LOGGER.info("topic = {}, partition = {}, offset = {}, processResourceRequest = {}",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), processResourceRequest);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
