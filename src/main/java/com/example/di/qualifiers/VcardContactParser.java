package com.example.di.qualifiers;

import com.opencsv.exceptions.CsvException;
import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.property.Email;
import ezvcard.property.Url;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Named("vcf")
@Singleton
public class VcardContactParser implements ContactParser {

    private static final Logger LOG = LoggerFactory.getLogger(VcardContactParser.class);

    @Override
    public Optional<Contact> parse(InputStream inputStream) {
        try {
            VCard vCard = Ezvcard.parse(inputStream).first();
            return Optional.of(new Contact(vCard.getStructuredName().getGiven() + " "
                    + vCard.getStructuredName().getFamily(),
                    vCard.getUrls().stream().map(Url::getValue).findFirst().orElse(""),
                    vCard.getEmails().stream().map(Email::getValue).findFirst().orElse("")));
        } catch (IOException e) {
            LOG.error("Error parsing VCF file", e);
        }
        return Optional.empty();
    }
}
