package com.example.di.injection_type;

import com.example.MessageService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/greet")
public class GreetingController {
    private final Logger LOG = LoggerFactory.getLogger(GreetingController.class);

    @Inject
    private MessageService messageService;

    public GreetingController() {
        LOG.info("GreetingController Constructor");
    }

    @PostConstruct
    void setup() {
        LOG.info("GreetingController PostConstruct");
    }

    @PreDestroy
    void cleanup() {
        LOG.info("GreetingController PreDestroy");
    }

    @Get
    String getMessage() {
        return messageService.message();
    }
}
