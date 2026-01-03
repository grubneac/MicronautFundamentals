package com.example.di.injection_type.field;

import com.example.MessageService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;

@Controller("/field")
public class MessageController {

    @Inject
    MessageService messageService;

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    String index() {
        return messageService.message();
    }
}
