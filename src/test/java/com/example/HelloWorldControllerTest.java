package com.example;

import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class HelloWorldControllerTest {

    @Test
    void getAll(@Client("/")HttpClient httpClient) {
        BlockingHttpClient blocking = httpClient.toBlocking();
        String json = assertDoesNotThrow(() -> blocking.retrieve("/hello"));
        assertEquals("""
                {"message":"Hello World"}""", json);

    }
}