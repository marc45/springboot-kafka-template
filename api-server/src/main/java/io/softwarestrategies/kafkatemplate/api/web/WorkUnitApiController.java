package io.softwarestrategies.kafkatemplate.api.web;

import io.softwarestrategies.kafkatemplate.api.service.WorkUnitProducerService;
import io.softwarestrategies.kafkatemplate.common.data.WorkUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkUnitApiController {

    private WorkUnitProducerService workUnitProducerService;

    @Autowired
    public WorkUnitApiController(WorkUnitProducerService workUnitProducerService) {
        this.workUnitProducerService = workUnitProducerService;
    }

    @PostMapping("/workunits")
    public boolean sendMessage(@RequestBody WorkUnit workUnit) {
        return workUnitProducerService.dispatch(workUnit);
    }
}
