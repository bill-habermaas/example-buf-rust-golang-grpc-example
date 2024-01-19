// @generated
#[allow(clippy::derive_partial_eq_without_eq)]
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct ExplorerRequest {
    #[prost(string, tag="1")]
    pub name: ::prost::alloc::string::String,
}
#[allow(clippy::derive_partial_eq_without_eq)]
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct ExplorerResponse {
    #[prost(string, tag="1")]
    pub message: ::prost::alloc::string::String,
}
include!("explorer.v1.serde.rs");
include!("explorer.v1.tonic.rs");
// @@protoc_insertion_point(module)