package main

import (
	"connectrpc.com/connect"
	"context"
	"fmt"
	explorerv1 "github.com/bufbuild/explorer/gen/proto/explorer/v1"
	"github.com/bufbuild/explorer/gen/proto/explorer/v1/explorerv1connect"
	"log"
	"net/http"
)

func main() {
	client := explorerv1connect.NewExplorerServiceClient(
		http.DefaultClient,
		"http://localhost:8080",
		connect.WithGRPC(),
	)
	request := &explorerv1.ExplorerRequest{Name: "Gophers"}
	resp, err := client.Explore(
		context.Background(),
		connect.NewRequest(request),
	)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Printf("Receive response => %s ", resp)
}
