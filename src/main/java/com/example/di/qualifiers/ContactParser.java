package com.example.di.qualifiers;

import java.io.InputStream;
import java.util.Optional;

public interface ContactParser {
    Optional<Contact> parse (InputStream inputStream);
}
