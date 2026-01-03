package com.example.di.bean_replacement;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.response.ErrorContext;
import io.micronaut.http.server.exceptions.response.HtmlErrorResponseBodyProvider;
import jakarta.inject.Singleton;

@Singleton
@Replaces(HtmlErrorResponseBodyProvider.class)
public class NotFoundErrorResponseBodyProvider implements HtmlErrorResponseBodyProvider {
    @Override
    public String body(@NonNull ErrorContext errorContext, @NonNull HttpResponse<?> response) {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8"/>
                    <title>404 Not Found</title>
                    <meta name="viewport" content="width=device-width,initial-scale=1"/>
                    <style> :root {
                        color-scheme: light dark;
                    }
                
                    body {
                        margin: 0;
                        font-family: system-ui, -apple-system, Segoe UI, Roboto, sans-serif;
                        display: grid;
                        place-items: center;
                        min-height: 100vh;
                        background: #0f172a;
                        color: #e2e8f0;
                    }
                
                    .card {
                        text-align: center;
                        padding: 2.5rem;
                        border-radius: 12px;
                        background: #111827;
                        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.35);
                        max-width: 520px;
                        width: 92%;
                    }
                
                    h1 {
                        margin: 0 0 .5rem;
                        font-size: 3rem;
                        letter-spacing: -0.02em;
                    }
                
                    p {
                        margin: 0 0 1.25rem;
                        line-height: 1.6;
                        color: #cbd5e1;
                    }
                
                    a {
                        display: inline-block;
                        padding: .7rem 1.1rem;
                        border-radius: 8px;
                        background: #3b82f6;
                        color: #fff;
                        text-decoration: none;
                        font-weight: 600;
                    }
                
                    a:focus, a:hover {
                        background: #2563eb;
                    }
                
                    .code {
                        font-family: ui-monospace, SFMono-Regular, Menlo, monospace;
                        color: #93c5fd;
                    } </style>
                </head>
                <body>
                <main class="card" role="main" aria-labelledby="title"><h1 id="title">404</h1>
                    <p>Sorry, the page you’re looking for can’t be found.</p>
                    <p><span class="code">Error: Not Found</span></p> <a href="/">Go back home</a></main>
                </body>
                """;
    }
}
