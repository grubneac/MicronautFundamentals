package com.example.di.qualifiers;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record Contact(
        String name,
        String url,
        String email
) {
}
