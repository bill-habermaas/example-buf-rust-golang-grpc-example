// Code generated by protoc-gen-connect-go. DO NOT EDIT.
//
// Source: explorer/v1/explorer.proto

package explorer_v1connect

import (
	connect "connectrpc.com/connect"
	context "context"
	errors "errors"
	explorer_v1 "explorer.v1"
	http "net/http"
	strings "strings"
)

// This is a compile-time assertion to ensure that this generated file and the connect package are
// compatible. If you get a compiler error that this constant is not defined, this code was
// generated with a version of connect newer than the one compiled into your binary. You can fix the
// problem by either regenerating this code with an older version of connect or updating the connect
// version compiled into your binary.
const _ = connect.IsAtLeastVersion1_13_0

const (
	// ExplorerServiceName is the fully-qualified name of the ExplorerService service.
	ExplorerServiceName = "explorer.v1.ExplorerService"
)

// These constants are the fully-qualified names of the RPCs defined in this package. They're
// exposed at runtime as Spec.Procedure and as the final two segments of the HTTP route.
//
// Note that these are different from the fully-qualified method names used by
// google.golang.org/protobuf/reflect/protoreflect. To convert from these constants to
// reflection-formatted method names, remove the leading slash and convert the remaining slash to a
// period.
const (
	// ExplorerServiceExploreProcedure is the fully-qualified name of the ExplorerService's explore RPC.
	ExplorerServiceExploreProcedure = "/explorer.v1.ExplorerService/explore"
)

// These variables are the protoreflect.Descriptor objects for the RPCs defined in this package.
var (
	explorerServiceServiceDescriptor       = explorer_v1.File_explorer_v1_explorer_proto.Services().ByName("ExplorerService")
	explorerServiceExploreMethodDescriptor = explorerServiceServiceDescriptor.Methods().ByName("explore")
)

// ExplorerServiceClient is a client for the explorer.v1.ExplorerService service.
type ExplorerServiceClient interface {
	Explore(context.Context, *connect.Request[explorer_v1.ExplorerRequest]) (*connect.Response[explorer_v1.ExplorerResponse], error)
}

// NewExplorerServiceClient constructs a client for the explorer.v1.ExplorerService service. By
// default, it uses the Connect protocol with the binary Protobuf Codec, asks for gzipped responses,
// and sends uncompressed requests. To use the gRPC or gRPC-Web protocols, supply the
// connect.WithGRPC() or connect.WithGRPCWeb() options.
//
// The URL supplied here should be the base URL for the Connect or gRPC server (for example,
// http://api.acme.com or https://acme.com/grpc).
func NewExplorerServiceClient(httpClient connect.HTTPClient, baseURL string, opts ...connect.ClientOption) ExplorerServiceClient {
	baseURL = strings.TrimRight(baseURL, "/")
	return &explorerServiceClient{
		explore: connect.NewClient[explorer_v1.ExplorerRequest, explorer_v1.ExplorerResponse](
			httpClient,
			baseURL+ExplorerServiceExploreProcedure,
			connect.WithSchema(explorerServiceExploreMethodDescriptor),
			connect.WithClientOptions(opts...),
		),
	}
}

// explorerServiceClient implements ExplorerServiceClient.
type explorerServiceClient struct {
	explore *connect.Client[explorer_v1.ExplorerRequest, explorer_v1.ExplorerResponse]
}

// Explore calls explorer.v1.ExplorerService.explore.
func (c *explorerServiceClient) Explore(ctx context.Context, req *connect.Request[explorer_v1.ExplorerRequest]) (*connect.Response[explorer_v1.ExplorerResponse], error) {
	return c.explore.CallUnary(ctx, req)
}

// ExplorerServiceHandler is an implementation of the explorer.v1.ExplorerService service.
type ExplorerServiceHandler interface {
	Explore(context.Context, *connect.Request[explorer_v1.ExplorerRequest]) (*connect.Response[explorer_v1.ExplorerResponse], error)
}

// NewExplorerServiceHandler builds an HTTP handler from the service implementation. It returns the
// path on which to mount the handler and the handler itself.
//
// By default, handlers support the Connect, gRPC, and gRPC-Web protocols with the binary Protobuf
// and JSON codecs. They also support gzip compression.
func NewExplorerServiceHandler(svc ExplorerServiceHandler, opts ...connect.HandlerOption) (string, http.Handler) {
	explorerServiceExploreHandler := connect.NewUnaryHandler(
		ExplorerServiceExploreProcedure,
		svc.Explore,
		connect.WithSchema(explorerServiceExploreMethodDescriptor),
		connect.WithHandlerOptions(opts...),
	)
	return "/explorer.v1.ExplorerService/", http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		switch r.URL.Path {
		case ExplorerServiceExploreProcedure:
			explorerServiceExploreHandler.ServeHTTP(w, r)
		default:
			http.NotFound(w, r)
		}
	})
}

// UnimplementedExplorerServiceHandler returns CodeUnimplemented from all methods.
type UnimplementedExplorerServiceHandler struct{}

func (UnimplementedExplorerServiceHandler) Explore(context.Context, *connect.Request[explorer_v1.ExplorerRequest]) (*connect.Response[explorer_v1.ExplorerResponse], error) {
	return nil, connect.NewError(connect.CodeUnimplemented, errors.New("explorer.v1.ExplorerService.explore is not implemented"))
}
