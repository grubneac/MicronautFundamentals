package com.example.http_client;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;

import javax.naming.ConfigurationException;
import java.io.Closeable;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Collections;
import java.util.List;

@Singleton
public class PostClient implements AutoCloseable{
    private static final String PATH_POST ="/posts";
    public static final HttpRequest<?> GET_POSTS = HttpRequest.GET(PATH_POST);
    public static final Argument<List<Post>> ARG_LIST_POSTS = Argument.listOf(Post.class);
    public static final Argument<Post> ARG_POST = Argument.of(Post.class);
    private final BlockingHttpClient client;

    public PostClient() throws ConfigurationException {
        String uri = "https://jsonplaceholder.typicode.com/";
        try {
            this.client= HttpClient.create(URI.create(uri).toURL()).toBlocking();
        } catch (MalformedURLException e) {
            throw new ConfigurationException("malformed URL exception for " + uri);
        }
    }

    public List<Post> fetchPostsRetrieve() {
        return client.retrieve(GET_POSTS,ARG_LIST_POSTS);
    }

    public List<Post> fetchPostsExchange() {
        HttpResponse<List<Post>> httpResponse = client.exchange(GET_POSTS, ARG_LIST_POSTS);
        return httpResponse.getBody().orElse(Collections.emptyList());
    }

    public Post fetchPostById(String id) {
        return client.retrieve(HttpRequest.GET(UriBuilder.of(PATH_POST).path(id).build()), ARG_POST);
    }

    @Override
    public void close() throws Exception {
        if(this.client instanceof Closeable closeable) {
            closeable.close();
        }
    }
}
