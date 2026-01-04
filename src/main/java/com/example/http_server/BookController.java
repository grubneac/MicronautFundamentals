package com.example.http_server;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/books")
public class BookController {
    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
    public static final Book NETTY_IN_ACTION =
            new Book("Netty in Action", "3245276", 263);

    @Get("/show")
    Book show(HttpRequest<?> httpRequest) {
        for (String name : httpRequest.getHeaders().names()) {
            LOG.info("Header {}  : {}", name, httpRequest.getHeaders().get(name));
        }
        return NETTY_IN_ACTION;
    }

    @Get("/list")
    List<Book> list(@QueryValue("src") @Nullable String utc_source) {
        LOG.info("Query parameter utc_source: {}", utc_source);

        return List.of(NETTY_IN_ACTION);
    }

    @Get("/list/response")
    HttpResponse<List<Book>> listHttpResponse() {
        return HttpResponse.ok(List.of(NETTY_IN_ACTION));
    }

    @Get("/list/status")
    HttpResponse<List<Book>> listStatus() {
        return HttpResponse.status(HttpStatus.OK)
                .body(List.of(NETTY_IN_ACTION));
    }
}
