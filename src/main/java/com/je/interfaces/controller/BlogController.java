package com.je.interfaces.controller;

import com.je.application.ro.CreateBlogRo;
import com.je.application.service.BlogService;
import com.je.domain.Blog;
import com.je.interfaces.Result;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.inject.Inject;
import java.util.List;

@ExecuteOn(TaskExecutors.IO)
@Controller("/blog")
public class BlogController {

    @Inject
    private BlogService blogService;

    @Post("/create")
    public Result<Blog> create(@Body CreateBlogRo ro) {
        return Result.ok(blogService.create(ro));
    }

    @Get("/list")
    public Result<List<Blog>> list() {
        return Result.ok(blogService.list());
    }

}
