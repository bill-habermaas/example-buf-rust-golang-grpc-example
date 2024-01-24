package com.locutis257.grpcdemo.controller;

import com.explorer.v1.ExplorerRequest;
import com.explorer.v1.ExplorerResponse;
import com.locutis257.grpcdemo.service.GrpcServerService;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the /explore api's
 */
@Slf4j
@RestController
@RequestMapping(
        value = "/explorer",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Observed(name = "explorer")
public class RestExplorerController {

    private final GrpcServerService grpcServerService;

    /**
     * Constructor that takes a GrpcServerService
     * @param grpcServerService
     */
    @Autowired
    public RestExplorerController(GrpcServerService grpcServerService) {
        this.grpcServerService = grpcServerService;
    }

    /**
     * Post explore Rest API
     * @param request ExploreRequest
     * @return ExplorerResponse with the explore message.
     */
    @PostMapping(value = "/explore")
    public ResponseEntity<ExplorerResponse> explore(@RequestBody ExplorerRequest request) {

        return new ResponseEntity<>(
                ExplorerResponse.newBuilder().setMessage("rest explore from java").build(),
                HttpStatus.OK);
    }
}

