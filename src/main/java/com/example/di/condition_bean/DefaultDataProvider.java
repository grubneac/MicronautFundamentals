package com.example.di.condition_bean;

import jakarta.inject.Singleton;

import java.time.LocalDate;

@Singleton
public class DefaultDataProvider implements DateProvider{
    @Override
    public LocalDate localDate() {
        return LocalDate.now();
    }
}
