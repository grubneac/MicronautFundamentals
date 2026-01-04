package com.example.http_server;

import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class BookControllerTest {

    @Test
    void listTest(@Client("/")HttpClient httpClient) {
        BlockingHttpClient client = httpClient.toBlocking();
        String expectedJsonArray = """
                [{"name":"Netty in Action","isbn":"3245276","pages":263}]""";

        String actualJason = assertDoesNotThrow(() -> client.retrieve("/books/list"));
        assertEquals(expectedJsonArray, actualJason);
        actualJason = assertDoesNotThrow(() -> client.retrieve("/books/list/response"));
        assertEquals(expectedJsonArray, actualJason);
        actualJason = assertDoesNotThrow(() -> client.retrieve("/books/list/status"));
        assertEquals(expectedJsonArray, actualJason);

    }
    @Test
    void showTest(@Client("/")HttpClient httpClient) {
        BlockingHttpClient client = httpClient.toBlocking();
        String expectedJson = """
                {"name":"Netty in Action","isbn":"3245276","pages":263}""";
        String actualJason = assertDoesNotThrow(() -> client.retrieve("/books/show"));
        assertEquals(expectedJson, actualJason);

    }
}