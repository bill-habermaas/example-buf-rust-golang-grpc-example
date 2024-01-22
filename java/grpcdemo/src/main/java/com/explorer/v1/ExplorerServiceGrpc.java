package com.explorer.v1;

import io.grpc.stub.StreamObserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: proto/explorer/v1/explorer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExplorerServiceGrpc {

  private ExplorerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "explorer.v1.ExplorerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.explorer.v1.ExplorerRequest,
      com.explorer.v1.ExplorerResponse> getExploreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "explore",
      requestType = com.explorer.v1.ExplorerRequest.class,
      responseType = com.explorer.v1.ExplorerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.explorer.v1.ExplorerRequest,
      com.explorer.v1.ExplorerResponse> getExploreMethod() {
    io.grpc.MethodDescriptor<com.explorer.v1.ExplorerRequest, com.explorer.v1.ExplorerResponse> getExploreMethod;
    if ((getExploreMethod = ExplorerServiceGrpc.getExploreMethod) == null) {
      synchronized (ExplorerServiceGrpc.class) {
        if ((getExploreMethod = ExplorerServiceGrpc.getExploreMethod) == null) {
          ExplorerServiceGrpc.getExploreMethod = getExploreMethod =
              io.grpc.MethodDescriptor.<com.explorer.v1.ExplorerRequest, com.explorer.v1.ExplorerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "explore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.explorer.v1.ExplorerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.explorer.v1.ExplorerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExplorerServiceMethodDescriptorSupplier("explore"))
              .build();
        }
      }
    }
    return getExploreMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExplorerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExplorerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExplorerServiceStub>() {
        @java.lang.Override
        public ExplorerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExplorerServiceStub(channel, callOptions);
        }
      };
    return ExplorerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExplorerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExplorerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExplorerServiceBlockingStub>() {
        @java.lang.Override
        public ExplorerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExplorerServiceBlockingStub(channel, callOptions);
        }
      };
    return ExplorerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExplorerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExplorerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExplorerServiceFutureStub>() {
        @java.lang.Override
        public ExplorerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExplorerServiceFutureStub(channel, callOptions);
        }
      };
    return ExplorerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void explore(com.explorer.v1.ExplorerRequest request,
        io.grpc.stub.StreamObserver<com.explorer.v1.ExplorerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExploreMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ExplorerService.
   */
  public static abstract class ExplorerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ExplorerServiceGrpc.bindService(this);
    }

    public abstract void Explore(ExplorerRequest request,
                                 StreamObserver<ExplorerResponse> responseObserver);
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ExplorerService.
   */
  public static final class ExplorerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ExplorerServiceStub> {
    private ExplorerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExplorerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExplorerServiceStub(channel, callOptions);
    }

    /**
     */
    public void explore(com.explorer.v1.ExplorerRequest request,
        io.grpc.stub.StreamObserver<com.explorer.v1.ExplorerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExploreMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ExplorerService.
   */
  public static final class ExplorerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExplorerServiceBlockingStub> {
    private ExplorerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExplorerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExplorerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.explorer.v1.ExplorerResponse explore(com.explorer.v1.ExplorerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExploreMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ExplorerService.
   */
  public static final class ExplorerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExplorerServiceFutureStub> {
    private ExplorerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExplorerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExplorerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.explorer.v1.ExplorerResponse> explore(
        com.explorer.v1.ExplorerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExploreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXPLORE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXPLORE:
          serviceImpl.explore((com.explorer.v1.ExplorerRequest) request,
              (io.grpc.stub.StreamObserver<com.explorer.v1.ExplorerResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getExploreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.explorer.v1.ExplorerRequest,
              com.explorer.v1.ExplorerResponse>(
                service, METHODID_EXPLORE)))
        .build();
  }

  private static abstract class ExplorerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExplorerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.explorer.v1.ExplorerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExplorerService");
    }
  }

  private static final class ExplorerServiceFileDescriptorSupplier
      extends ExplorerServiceBaseDescriptorSupplier {
    ExplorerServiceFileDescriptorSupplier() {}
  }

  private static final class ExplorerServiceMethodDescriptorSupplier
      extends ExplorerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ExplorerServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ExplorerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExplorerServiceFileDescriptorSupplier())
              .addMethod(getExploreMethod())
              .build();
        }
      }
    }
    return result;
  }
}
