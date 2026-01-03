package com.example.di.injection_type.constructor;

import com.example.MessageService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/constructor")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    String index() {
        return messageService.message();
    }
}
