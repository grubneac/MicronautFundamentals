package com.example.di.condition_bean;

import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class PirateHelloServiceTest {

    @Test
    void sauHello(HelloService helloService) {
        assertEquals("Ahoy", helloService.sauHello());
    }

    @MockBean(DateProvider.class)
    DateProvider pirateDateProvider() {
        return () ->  LocalDate.of(1980, Month.SEPTEMBER, 19);
    }
}