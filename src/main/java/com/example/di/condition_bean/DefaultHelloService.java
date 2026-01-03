package com.example.di.condition_bean;

import io.micronaut.context.annotation.Secondary;
import jakarta.inject.Singleton;

@Singleton
@Secondary
public class DefaultHelloService implements HelloService{
    @Override
    public String sauHello() {
        return "Hello";
    }
}
