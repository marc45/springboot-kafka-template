package io.softwarestrategies.kafkatemplate.api.service.impl;

import io.softwarestrategies.kafkatemplate.api.service.WorkUnitProducerService;
import io.softwarestrategies.kafkatemplate.common.data.WorkUnit;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class WorkUnitProducerServiceImpl implements WorkUnitProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkUnitProducerService.class);

    private KafkaTemplate<String, WorkUnit> workUnitsKafkaTemplate;

    @Autowired
    public WorkUnitProducerServiceImpl(KafkaTemplate<String, WorkUnit> workUnitsKafkaTemplate) {
        this.workUnitsKafkaTemplate = workUnitsKafkaTemplate;
    }

    public boolean dispatch(WorkUnit workUnit) {
        try {
            SendResult<String, WorkUnit> sendResult = workUnitsKafkaTemplate.sendDefault(workUnit.getId(), workUnit).get();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();
            LOGGER.info("topic = {}, partition = {}, offset = {}, workUnit = {}",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), workUnit);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
