package com.example.events;

import io.micronaut.context.event.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {
    public OrderEvent(Object source) {
        super(source);
    }
}
