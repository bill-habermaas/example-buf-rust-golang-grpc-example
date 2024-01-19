use std::result::Result;

use tonic::{async_trait, Request, Response, Status};

use crate::{explorer_service_server::ExplorerService, ExplorerRequest, ExplorerResponse};

/// The struct representing the `Examine` service.
///
/// # Example
///
/// Here is how you could run this service.
///
/// ```rust
/// # use anyhow::Error;
/// # use explorer::{explorer_service_server::*, service::Explorer};
/// # use tonic::transport::Server;
/// # use std::net::SocketAddr;
/// #[tokio::main]
/// async fn main() -> Result<(), Error> {
///     let addr: SocketAddr = "127.0.0.1:8080".parse()?;
///     let service = ExplorerServiceServer::new(Explorer {});
///
///     // (Commented out so that the doc-tests don't block running an actual server)
///     // Server::builder().add_service(service).serve(addr).await?;
///     Ok(())
/// }
/// ```
/// NOTE: The generated code requires you to create a struct that implements the [`ExplorerService`]
/// trait. I would have preferred for this struct to have been named `ExamineService`...but that is
/// already the trait's name! 🤔 I might want to find a better name than `Examine` if this were a
/// real project.
pub struct Explorer;

#[async_trait]
impl ExplorerService for Explorer {
    async fn explore(
        &self,
        request: Request<ExplorerRequest>,
    ) -> Result<Response<ExplorerResponse>, Status> {
        // Get the User-Agent header supplied in the request
        let name = request.into_inner().name;

        // This is the place to emit proper logging, tracing, metrics, etc. but since this is a toy
        // project, we'll just emit some info to the console.
        println!("{name:?} -> {name}");

        // Package up and return the response
        Ok(Response::new(ExplorerResponse {
            message: name,
        }))
    }
}

