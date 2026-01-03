package com.example;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class MessageService {
    private final Logger LOG = LoggerFactory.getLogger(MessageService.class);

    public MessageService() {
        LOG.info("MessageService Constructor");
    }

    @PostConstruct
    void setup() {
        LOG.info("MessageService PostConstruct");
    }

    public String message() {
        return "Hello World";
    }
}
