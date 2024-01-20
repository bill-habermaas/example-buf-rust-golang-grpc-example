# "Explorer" Client & Service

Practice creating grpc services and clients with buf.build, Rust, and tonic.

# The Task

> 
> This is a hybrid repository that contains builds for a gRPC client written in RUST and a gRPC server written in GOLANG. 
> 
> The goal is to demonstrate that it is possible to have a gRPC client written in one language to successfully communicate with a gRPC server written in a different language.
> The client and server are joined by a shared protobuf schema.


# Protobuf Definitions

The (handwritten) protobuf file is in `proto/explorer/v1/exployer.proto`. `buf generate proto' was used to
generate the code. Buf demonstrates how to generate protobuf generated code in different languages.



# Server  (GOLANG)

The code for the server binary is in golang/server/main.go
### Running the server...
go
```shell
go run server/main.go
```

# Client (RUST)

The client simply sends a message to the server and prints the reply. 

### Running the client

While you can run the client through cargo, 

```shell
cargo run -r --bin client 
```

