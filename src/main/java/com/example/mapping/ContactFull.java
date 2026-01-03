package com.example.mapping;

import java.util.List;

public record ContactFull(
        String firstName,
        String lastName,
        String jobTitle,
        String company,
        List<String> urls
) {
}
