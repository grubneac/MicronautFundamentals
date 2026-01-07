package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Collections;
import java.util.Map;

@Controller("/hello")
public class HelloWorldController {
    private final MessageService messageService;

    public HelloWorldController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Get
    Map<String, Object> getAll() {
        return Collections.singletonMap("message", messageService.message());
    }
}
