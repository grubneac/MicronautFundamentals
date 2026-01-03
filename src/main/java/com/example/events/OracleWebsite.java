package com.example.events;


import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.util.StringUtils;
import io.micronaut.sourcegen.annotations.Builder;
import org.jetbrains.annotations.NotNull;

@Builder
@Introspected(accessKind = Introspected.AccessKind.FIELD)
public record OracleWebsite(String url, String countryRegion) {
    @Override
    public @NotNull String toString() {
        if(StringUtils.isEmpty(countryRegion)) {
            return url;
        } else {
            return url + "/" + countryRegion + "/";
        }
    }
}
