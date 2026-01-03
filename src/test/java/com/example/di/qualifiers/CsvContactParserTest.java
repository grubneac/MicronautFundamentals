package com.example.di.qualifiers;

import io.micronaut.core.io.ResourceLoader;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Named;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(startApplication = false)
class CsvContactParserTest {

    @Test
    void csvContactParserTest(@Named("csv") ContactParser contactParser,
                              ResourceLoader resourceLoader) throws IOException {
        assertInstanceOf(CsvContactParser.class, contactParser);
        Optional<InputStream> resource = resourceLoader.getResourceAsStream("classpath:micronaut.csv");
        assertTrue(resource.isPresent());
        try (InputStream inputStream = resource.get()){
            Optional<Contact> contactOptional = contactParser.parse(inputStream);
            assertTrue(contactOptional.isPresent());
            assertEquals(new Contact("Micronaut Framework","https:/micronaut.io", "info@micronaut.io")
                    , contactOptional.get());
        }
    }

}