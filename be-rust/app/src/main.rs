use warp::{Filter};
use std::collections::HashMap;

async fn get_whoami(
    ) -> Result<impl warp::Reply, warp::Rejection> {
        let mut result = HashMap::new();

        result.insert("app", "rust");
        result.insert("message", "I 💕 RUST!!!");

        Ok(warp::reply::json(
            &result
        ))
}

#[tokio::main]
async fn main() {
    
    let get_items = warp::get()
        .and(warp::path("v1"))
        .and(warp::path("whoami"))
        .and(warp::path::end())
        .and_then(get_whoami);
    
    let routes = get_items;
    println!("Starting server on port 3030");
    warp::serve(routes)
        .run(([127, 0, 0, 1], 3030))
        .await;
}