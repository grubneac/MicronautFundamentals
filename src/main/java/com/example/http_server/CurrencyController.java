package com.example.http_server;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.math.BigDecimal;

@Controller
public class CurrencyController {

    @Get("/exchange/{fromCurrencyCode}/{toCurrencyCode}/")
    Exchange exchange(@PathVariable("fromCurrencyCode") String fromPath,
                      @PathVariable String toCurrencyCode) {

        BigDecimal rate = new BigDecimal("0.91");
        return new Exchange(fromPath, toCurrencyCode, rate);
    }
}
