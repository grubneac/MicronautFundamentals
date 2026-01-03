package com.example.configuration;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class BlogController2ValueAnnotationTest {

    private static final @NonNull Argument<List<Post>> ARG_LIST_POST =
            Argument.listOf(Post.class);

    @Test
    void test(@Client("/")HttpClient httpClient) {
        BlockingHttpClient client = httpClient.toBlocking();
        HttpRequest<?> request = HttpRequest.GET("/blog-value");
        List<Post> posts = assertDoesNotThrow(() -> client.retrieve(request, ARG_LIST_POST));
        assertEquals(2, posts.size());
    }

}