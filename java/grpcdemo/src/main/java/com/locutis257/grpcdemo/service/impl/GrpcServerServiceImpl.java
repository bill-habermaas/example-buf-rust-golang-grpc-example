package com.locutis257.grpcdemo.service.impl;

import com.explorer.v1.ExplorerRequest;
import com.explorer.v1.ExplorerResponse;
import com.explorer.v1.ExplorerServiceGrpc;
import com.locutis257.grpcdemo.service.GrpcServerService;
import org.springframework.stereotype.Service;

@Service
public class GrpcServerServiceImpl implements GrpcServerService {

    public GrpcServerServiceImpl() {
    }

    @Override
    public ExplorerResponse Explore(ExplorerRequest request) {
        return null;
    }
}
