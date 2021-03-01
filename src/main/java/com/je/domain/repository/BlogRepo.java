package com.je.domain.repository;

import com.je.domain.Blog;
import io.micronaut.data.annotation.Repository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class BlogRepo {

    public void create(Blog blog) {
        // todo
        log.info("saved success, {}", blog);
    }

    public List<Blog> list() {
        // todo
        List<Blog> blogs = new ArrayList<>();
        log.info("listed success, size: {}", blogs.size());
        return blogs;
    }

}
