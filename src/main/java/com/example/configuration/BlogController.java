package com.example.configuration;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/blog")
public class BlogController {

    private static final Logger LOG = LoggerFactory.getLogger(BlogController.class);

    private final int max;
    private final BlogRepository blogRepository;


    public BlogController(BlogConfiguration blogConfiguration, BlogRepository blogRepository) {
        this.max = blogConfiguration.getPostsPerPage();
        this.blogRepository = blogRepository;
    }

    @Get
    List<Post> posts() {
        LOG.info("Info from configuration 'posts-per-page': {}", max);
        return blogRepository.findAll(max);
    }
}
