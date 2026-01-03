package com.example.di.qualifiers;

import io.micronaut.core.io.ResourceLoader;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest(startApplication = false)
public class MapContactParserTest {

    private static final Logger LOG = LoggerFactory.getLogger(MapContactParserTest.class);

    @Inject
    Map<String, ContactParser> contactParserMap;

    @Inject
    ResourceLoader resourceLoader;

    @Test
    void contactParser() throws IOException {
        for (Map.Entry<String, ContactParser> entry : contactParserMap.entrySet()) {
            ContactParser contactParser = entry.getValue();
            String formatFile = entry.getKey();
            LOG.info("Start testing format: {}",formatFile);
            Optional<InputStream> resource = resourceLoader.getResourceAsStream("classpath:micronaut." + formatFile);
            assertTrue(resource.isPresent());
            try (InputStream inputStream = resource.get()) {
                Optional<Contact> contactOptional = contactParser.parse(inputStream);
                assertTrue(contactOptional.isPresent());
                assertEquals(new Contact("Micronaut Framework", "https:/micronaut.io", "info@micronaut.io")
                        , contactOptional.get());
            }
        }
    }
}
