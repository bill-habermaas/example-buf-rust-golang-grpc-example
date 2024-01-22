package com.locutis257.grpcdemo.service;

import com.explorer.v1.ExplorerRequest;
import com.explorer.v1.ExplorerResponse;

public interface GrpcServerService {

    ExplorerResponse Explore(ExplorerRequest request);
}
