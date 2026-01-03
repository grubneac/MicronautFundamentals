package com.example.mapping;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest(startApplication = false)
public class ContactBeanMapperTest {

    @Test
    void beanMapperTest(ContactMapper contactMapper){
        ContactCard expected = new ContactCard("Tim Cook", "Apple Inc");
        ContactFull contactFull = new ContactFull("Tim", "Cook", "CEO", "Apple Inc",
                List.of("http://apple.com/tim-cook/"));
        ContactCard actual = contactMapper.contactFullToContactCard(contactFull);
        assertEquals(expected, actual);
    }
}
