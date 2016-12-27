package io.softwarestrategies.kafkatemplate.api.web;

import io.softwarestrategies.kafkatemplate.api.service.WorkUnitProducerService;
import io.softwarestrategies.kafkatemplate.common.data.WorkUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkUnitApiController {

    private WorkUnitProducerService workUnitProducerService;

    @Autowired
    public WorkUnitApiController(WorkUnitProducerService workUnitProducerService) {
        this.workUnitProducerService = workUnitProducerService;
    }

    @GetMapping("/generateWork")
    public boolean sendMessage(WorkUnit workUnit) {
        return workUnitProducerService.dispatch(workUnit);
    }
}
