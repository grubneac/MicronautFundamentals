package com.example.di.injection_type.method_parameter;

import com.example.MessageService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;

@Controller("/setter")
public class MessageController {

    private MessageService messageService;

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    String index() {
        return messageService.message();
    }

    @Inject
    void init(MessageService messageService) {
        this.messageService = messageService;
    }
}
