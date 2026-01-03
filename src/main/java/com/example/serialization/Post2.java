package com.example.serialization;

import io.micronaut.serde.annotation.Serdeable;

public record Post2(
        Long id,
        Long userId,
        String title,
        String body
) {
}
