package com.example.configuration;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(startApplication = false, environments = "prod")
class BlogConfigurationTest {

    @Test
    void test(BlogConfiguration blogConfiguration) {
        assertEquals(1, blogConfiguration.getPostsPerPage());
    }

}