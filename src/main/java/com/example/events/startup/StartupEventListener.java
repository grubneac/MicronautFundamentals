package com.example.events.startup;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class StartupEventListener {

    private static final Logger LOG = LoggerFactory.getLogger(StartupEventListener.class);

    @EventListener
    public void onStartup(StartupEvent startupEvent) {
        LOG.info("Application started. Logging from method annotated with EventListener");
    }

}
