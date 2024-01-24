use anyhow::Error;
use explorer::{explorer_service_server::*, service::Explorer};
use tonic::transport::Server;

#[tokio::main]
async fn main() -> Result<(), Error> {
    let addr = "127.0.0.1:6565".parse()?;
    let service = ExplorerServiceServer::new(Explorer {});

    Server::builder().add_service(service).serve(addr).await?;
    Ok(())
}
