package com.example.di;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MessageControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @ParameterizedTest
    @ValueSource(strings = {"/constructor","/field", "/setter"})
    void validateMessageController(String path) {
        assertEquals("Hello World", httpClient.toBlocking()
                .retrieve(HttpRequest.GET(path).accept(MediaType.TEXT_PLAIN)));
    }


}