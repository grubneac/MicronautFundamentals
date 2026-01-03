package com.example.mapping;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactManualMapperTest {

    @Test
    void beanMapperTest() {
        ContactCard expected = new ContactCard("Tim Cook", "Apple Inc");
        ContactFull contactFull = new ContactFull("Tim", "Cook", "CEO", "Apple Inc",
                List.of("http://apple.com/tim-cook/"));
        ContactCard actual = contactFullToContactCard(contactFull);

        assertEquals(expected, actual);

    }

    private static ContactCard contactFullToContactCard(ContactFull source) {
        return new ContactCard(String.join(" ",source.firstName(), source.lastName()), source.company());
    }
}
