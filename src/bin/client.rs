use anyhow::Error;
use clap::Parser;
use clap_stdin::MaybeStdin;
use explorer::{explorer_service_client::ExplorerServiceClient, ExplorerRequest};
use tonic::Request;

/// `client` checks user agent string(s)and emits whether to Allow or Block for each one.
#[derive(Parser, Debug)]
#[command(author, version, about, long_about = None)]
struct Args {
    /// User-Agent string of the browser. Use `-` to indicate reading from stdin instead.
    user_agent: MaybeStdin<String>,
}

#[tokio::main]
async fn main() -> Result<(), Error> {
    // Parse command-line arguments
    let args = Args::parse();
    // There may be multiple user agents separated by newlines
    let user_agents: Vec<String> = args
        .user_agent
        .split("\n")
        .map(|s| s.to_string())
        .filter(|s| !s.is_empty())
        .collect();

    // Set up the client
    let mut client = ExplorerServiceClient::connect("http://127.0.0.1:8080").await?;

    let request = Request::new(ExplorerRequest { name: "bill".to_string() });
    let response = client.explore(request).await?;
    let action = response.into_inner().message();
    println!("{action:?}");

    Ok(())
}
