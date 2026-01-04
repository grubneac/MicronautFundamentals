package com.example.http_server;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Book(String name, String isbn, Integer pages) {
}
