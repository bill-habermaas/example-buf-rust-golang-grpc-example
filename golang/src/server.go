package main

import (
	"connectrpc.com/connect"
	"context"
	"fmt"
	explorerv1 "github.com/bufbuild/explorer/gen/proto/explorer/v1"
	"github.com/bufbuild/explorer/gen/proto/explorer/v1/explorerv1connect"
	"golang.org/x/net/http2"
	"golang.org/x/net/http2/h2c"
	"log"
	"net/http"
)

const address = "localhost:8080"

func main() {
	mux := http.NewServeMux()
	path, handler := explorerv1connect.NewExplorerServiceHandler(&explorerServiceServer{})
	mux.Handle(path, handler)
	fmt.Println("Go /explorer.v1.ExplorerServer Listening on", address)
	http.ListenAndServe(
		address,
		// Use h2c so we can serve HTTP/2 without TLS.
		h2c.NewHandler(mux, &http2.Server{}),
	)
}

// ExplorerServiceServer implements the PetStoreService API.
type explorerServiceServer struct {
	explorerv1connect.UnimplementedExplorerServiceHandler
}

// explore adds the pet associated with the given request into the PetStore.
func (s *explorerServiceServer) Explore(
	ctx context.Context,
	req *connect.Request[explorerv1.ExplorerRequest],
) (*connect.Response[explorerv1.ExplorerResponse], error) {
	name := req.Msg.GetName()
	log.Printf("Got a request to create named %s", name)
	return connect.NewResponse(&explorerv1.ExplorerResponse{
	Message: "hello", }), nil
}
