package com.example.di.bean_factory;

import com.example.di.condition_bean.HelloService;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(startApplication = false)
class HelloServiceFactoryTest {

    @Test
    void hello (HelloService helloService) {
        assertEquals("Ahoy", helloService.sayHello());
    }
}