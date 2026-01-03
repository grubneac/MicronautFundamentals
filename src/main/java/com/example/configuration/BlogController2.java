package com.example.configuration;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/blog-value")
public class BlogController2 {

    private static final Logger LOG = LoggerFactory.getLogger(BlogController2.class);

    private final int max;
    private final BlogRepository blogRepository;


    public BlogController2(@Value("${blog.posts2-per-page:2}") Integer max, BlogRepository blogRepository) {
        this.max = max;
        this.blogRepository = blogRepository;
    }

    @Get
    List<Post> posts() {
        LOG.info("Info from configuration 'posts2-per-page': {}", max);
        return blogRepository.findAll(max);
    }
}
