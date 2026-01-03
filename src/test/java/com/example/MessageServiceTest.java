package com.example;

import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(startApplication = false)
class MessageServiceTest {

    @Test
    void applicationContextWithoutMicronautTest(MessageService messageService) {
        assertEquals("Hello World", messageService.message());
    }

}