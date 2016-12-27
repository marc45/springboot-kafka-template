package io.softwarestrategies.kafkatemplate.api.service;

import io.softwarestrategies.kafkatemplate.common.data.WorkUnit;

public interface WorkUnitProducerService {
    boolean dispatch(WorkUnit workUnit);
}
