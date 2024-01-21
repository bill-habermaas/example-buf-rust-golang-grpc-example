# "Explorer" Clients & Services

Practice creating grpc services and clients with buf.build, Rust, and tonic.

# The Task

> 
> This is a hybrid repository that contains builds for a gRPC client written in RUST and a gRPC server written in GOLANG. 
> 
> The goal is to demonstrate that it is possible to have a gRPC client written in one language to successfully communicate with a gRPC server written in a different language.
> The client and server are joined by a shared protobuf schema.
> 
> Currently this does not work !!!

# Protobuf Definitions

The (handwritten) protobuf file is in `proto/explorer/v1/exployer.proto`. `buf generate' will
generate the code. Buf demonstrates how to generate protobuf generated code in different languages.

# Server  (GOLANG)

The code for the server binary is in golang/src/server.go
### Running the server...

```shell
cd golang
go run src/server.go
```

# Client (GOLANG)

The code for talking to the server 
is in golang/src/client.go. This is provided to verify communcation can work in the same language. 
###
```shell
cd golang
go run src/client.go
```

# Client (RUST)

The client simply sends a message to the server and prints the reply. 

### Running the client

Run the client through cargo from the project directory. 

```shell
cargo run -r --bin client 
```
For testing the connection use the buf curl script ./runbuf.sh
