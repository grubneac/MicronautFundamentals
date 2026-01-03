package com.example.configuration;

import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class BlogRepository {

    List<Post> posts = List.of(
            new Post("Title post 0"),
            new Post("Title post 1"),
            new Post("Title post 2"),
            new Post("Title post 3"),
            new Post("Title post 4"),
            new Post("Title post 5"),
            new Post("Title post 6"),
            new Post("Title post 7"),
            new Post("Title post 8"),
            new Post("Title post 9"),
            new Post("Title post 10")
    );

    public List<Post> findAll(int max) {
        return posts.subList(0, Math.min(max, posts.size()));
    }
}
