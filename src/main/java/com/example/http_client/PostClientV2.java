package com.example.http_client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@Client(id = "jsonplaceholder")
public interface PostClientV2{
    @Get("/posts")
    List<Post> fetchPosts();

    @Get("/posts/{id}")
    Post findById(@PathVariable String id);
}
