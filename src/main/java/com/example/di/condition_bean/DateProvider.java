package com.example.di.condition_bean;

import io.micronaut.context.annotation.DefaultImplementation;

import java.time.LocalDate;

@DefaultImplementation(DefaultDataProvider.class)
public interface DateProvider {
    LocalDate localDate();
}
