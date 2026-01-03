package com.example.events;

import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller("/order")
public class OrderController {

    private final ApplicationEventPublisher<OrderEvent> orderEventPublisher;

    public OrderController(ApplicationEventPublisher<OrderEvent> orderEventPublisher) {
        this.orderEventPublisher = orderEventPublisher;
    }

    @Post
    @Status(HttpStatus.CREATED)
    void save(){
        Order order = new Order(new BigDecimal("100.00"), LocalDateTime.now());
        OrderEvent orderEvent = new OrderEvent(order);
        orderEventPublisher.publishEvent(orderEvent);
    }
}
