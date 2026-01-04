package com.example.http_client;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(startApplication = false)
class PostClientV2Test {

    @Test
    void fetchPostsTest(PostClientV2 postClient) {
        List<Post> posts = postClient.fetchPosts();
        assertNotNull(posts);
        assertEquals(100, posts.size());
    }

    @Test
    void existingPost(PostClientV2 postClient) {
        Post post = postClient.findById("1");
        assertEquals(1 , post.id());
    }

    @Test
    void notExistingPost(PostClientV2 postClient) {
        Post post = assertDoesNotThrow(() -> postClient.findById("999"));
        assertNull(post);

    }
}