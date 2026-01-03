package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@MicronautTest
class ContactControlerTest {

    @Inject
    ContractRepository contractRepository;

    @Test
    void deleteDelegateToRepository(@Client("/")HttpClient httpClient) {
        BlockingHttpClient client = httpClient.toBlocking();
        Long contractId = 6L;
        URI uri = UriBuilder.of("/contact").path("" + contractId).build();
        MutableHttpRequest<?> request = HttpRequest.DELETE(uri);
        HttpResponse<?> response = assertDoesNotThrow(() -> client.exchange(request));
        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());
        verify(contractRepository).delete(contractId);


    }

    @MockBean(ContractRepository.class)
    ContractRepository contractRepository() {
        return mock(ContractRepository.class);
    }

}