package com.example.http_server;

import io.micronaut.serde.annotation.Serdeable;
import org.jetbrains.annotations.NotNull;

@Serdeable
public record Book(String name, String isbn, Integer pages) {
    @Override
    public @NotNull String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pages=" + pages +
                '}';
    }
}
