package com.example.configuration;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(startApplication = false)
class UserTest {

    @Inject
    List<User> users;

    @Test
    void users() {
        assertNotNull(users);
        assertEquals(2, users.size());
        User sdelamo = expectedSdelamo();
        User tim = expectedTim();
        assertTrue(users.stream().anyMatch(u -> u.equals(tim)));
        assertTrue(users.stream().anyMatch(u -> u.equals(sdelamo)));

    }

    private User expectedTim() {
        User tim = new User("tim");
        tim.setEmail("tim@mail.com");
        tim.setPassword("passw2");
        tim.setRoles(List.of("ROLE_USER"));
        return tim;
    }

    private User expectedSdelamo() {
        User sdelamo = new User("sdelamo");
        sdelamo.setEmail("sdelamo@mail.com");
        sdelamo.setPassword("password");
        sdelamo.setRoles(List.of("ROLE_ADMIN", "ROLE_USER"));
        return sdelamo;
    }

}