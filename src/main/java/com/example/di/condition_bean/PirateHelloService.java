package com.example.di.condition_bean;

import io.micronaut.context.annotation.Requires;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton
@Named("pirate")
@Requires(condition = PirateDayCondition.class)
public class PirateHelloService implements HelloService{
    @Override
    public String sayHello() {
        return "Ahoy";
    }
}
