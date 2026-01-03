package com.example.di.condition_bean;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class HelloServiceTest {

    @Test
    void sauHello(HelloService helloService) {
        assertEquals("Hello", helloService.sauHello());
    }
}