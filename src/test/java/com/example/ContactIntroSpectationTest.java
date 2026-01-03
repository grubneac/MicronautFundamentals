package com.example;

import io.micronaut.core.beans.BeanIntrospection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledInNativeImage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContactIntroSpectationTest {

    @Test
    @DisabledInNativeImage
    void loadCsvAndInstantiateObjectViaBeanIntrospection() throws URISyntaxException, IOException {
        URL resource = getClass().getClassLoader().getResource("apple.csv");
        assertNotNull(resource, "File apple.csv not found");
        Path path = Path.of(resource.toURI());
        List<String> lines = Files.readAllLines(path);

        BeanIntrospection<Contact> introspection = BeanIntrospection.getIntrospection(Contact.class);

        List<Contact> contactList = lines.stream()
                .map(l -> introspection.instantiate((Object[]) l.split(",")))
                .toList();

        List<Contact> expected = List.of(
                new Contact("Tim Cook", "CEO", "Apple Inc"),
                new Contact("Craig Federighi", "Senior Vice President", "Apple Inc")
        );

        assertEquals(expected, contactList);

    }
}
