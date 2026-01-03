package com.example;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record Contact(
        String name,
        String jobTitle,
        String company
) {
}
