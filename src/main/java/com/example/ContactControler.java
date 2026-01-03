package com.example;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Status;

@Controller("/contact")
public class ContactControler {
    private final ContractRepository contractRepository;

    public ContactControler(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id) {
        contractRepository.delete(id);
    }
}
