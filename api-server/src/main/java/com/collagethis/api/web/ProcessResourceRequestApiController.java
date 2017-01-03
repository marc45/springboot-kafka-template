package com.collagethis.api.web;

import com.collagethis.api.service.ProcessResourceRequestService;
import com.collagethis.common.data.ProcessResourceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessResourceRequestApiController {

    private ProcessResourceRequestService processResourceRequestService;

    @Autowired
    public ProcessResourceRequestApiController(ProcessResourceRequestService processResourceRequestService) {
        this.processResourceRequestService = processResourceRequestService;
    }

    @PostMapping("/processresourcerequests")
    public boolean sendMessage(@RequestBody ProcessResourceRequest processResourceRequest) {
        return processResourceRequestService.dispatch(processResourceRequest);
    }
}
