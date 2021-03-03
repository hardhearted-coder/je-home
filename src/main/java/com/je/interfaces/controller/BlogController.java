package com.je.interfaces.controller;

import com.je.application.ro.CreateBlogRo;
import com.je.application.ro.UpdateBlogRo;
import com.je.application.service.BlogService;
import com.je.domain.Blog;
import com.je.interfaces.Result;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ExecuteOn(TaskExecutors.IO)
@Controller("/blogs")
public class BlogController {

    @Inject
    private BlogService blogService;

    @Post
    public Result<Blog> create(@Body CreateBlogRo ro) {
        return Result.ok(blogService.create(ro));
    }

    @Put
    public Result<Blog> update(@Body UpdateBlogRo ro) {
        return Result.ok(blogService.update(ro));
    }

    @Get
    public Result<List<Blog>> list() {
        return Result.ok(blogService.list());
    }

    @Get("/{id}")
    public Result<Optional<Blog>> find(@PathVariable("id") long id) {
        return Result.ok(blogService.find(id));
    }

}
