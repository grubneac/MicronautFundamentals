package com.example.di.bean_factory;

import com.example.di.condition_bean.HelloService;
import com.example.di.condition_bean.PirateHelloService;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Factory
public class HelloServiceFactory {

    @Named("pirates")
    @Singleton
    HelloService helloService() {
        return new PirateHelloService();
    }
}
