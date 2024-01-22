package com.locutis257.grpcdemo.controller;

import com.explorer.v1.ExplorerRequest;
import com.explorer.v1.ExplorerResponse;
import com.explorer.v1.ExplorerServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@Slf4j
@GRpcService
public class GrpcExplorerController extends ExplorerServiceGrpc.ExplorerServiceImplBase {

    @Override
    public void Explore(ExplorerRequest request,
                        StreamObserver<ExplorerResponse> responseObserver) {

        log.info("Request: ", request.toString());

        ExplorerResponse response = ExplorerResponse.newBuilder()
                .setMessage("From vava" +request.getName()).build();
        log.info("Respnse: "+response.toString());

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
