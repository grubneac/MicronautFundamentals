package com.example.configuration;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/blog-property")
public class BlogController3 {

    private static final Logger LOG = LoggerFactory.getLogger(BlogController3.class);

    private final int max;
    private final BlogRepository blogRepository;


    public BlogController3(@Property(name = "blog.posts3-per-page") Integer max, BlogRepository blogRepository) {
        this.max = max;
        this.blogRepository = blogRepository;
    }

    @Get
    List<Post> posts() {
        LOG.info("Info from configuration 'posts3-per-page': {}", max);
        return blogRepository.findAll(max);
    }
}
