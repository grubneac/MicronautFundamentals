package com.example.serialization;

import io.micronaut.json.JsonMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(startApplication = false)
class PostTest {

    @Test
    void deserializationFromJson(JsonMapper jsonMapper) throws IOException {
        var json = """
                {
                    "userId": 3,
                    "id": 1,
                    "title": "Great title",
                    "body": "actual's body"
                }
                """;
        Post actual = jsonMapper.readValue(json, Post.class);
        assertNotNull(actual);
        assertEquals(3, actual.userId());
        assertEquals(1, actual.id());
        assertEquals("Great title", actual.title());
        assertEquals("actual's body", actual.body());

    }

    @Test
    void serializationToJson(JsonMapper jsonMapper) throws IOException {
        var expected = """
                {
                    "userId": 3,
                    "id": 1,
                    "title": "Great title",
                    "body": "actual's body"
                }
                """;
        Post post = new Post(1L, 3L, "Great title", "actual's body");
        String actual = jsonMapper.writeValueAsString(post);
        JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
    }
}