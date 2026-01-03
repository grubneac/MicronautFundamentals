package com.example.configuration;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Post(String title) {
}
