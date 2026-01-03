package com.example.events.startup;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class BootStrap implements ApplicationEventListener<StartupEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(BootStrap.class);
    @Override
    public void onApplicationEvent(StartupEvent event) {
        LOG.info("Application started. Logging from ApplicationEventListener(BootStrap)");
    }
}
