package com.example.http_client;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(startApplication = false)
class PostClientTest {

    @Test
    void fetchPostsTest(PostClient postClient) {
        List<Post> posts = postClient.fetchPostsRetrieve();
        assertNotNull(posts);
        assertEquals(100, posts.size());
        posts = postClient.fetchPostsExchange();
        assertEquals(100, posts.size());
    }

    @Test
    void existingPost(PostClient postClient) {
        Post post = postClient.fetchPostById("1");
        assertEquals(1 , post.id());
    }

    @Test
    void notExistingPost(PostClient postClient) {
        HttpClientResponseException ex = assertThrows(HttpClientResponseException.class, () -> postClient.fetchPostById("999"));

        assertEquals(HttpStatus.NOT_FOUND, ex.getStatus());

    }
}