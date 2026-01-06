package com.example.http_server;

import io.micronaut.serde.annotation.Serdeable;

import java.math.BigDecimal;

@Serdeable
public record Exchange(String from, String currency, BigDecimal rate) {
}
