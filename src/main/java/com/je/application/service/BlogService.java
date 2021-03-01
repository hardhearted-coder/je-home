package com.je.application.service;

import com.je.application.ro.CreateBlogRo;
import com.je.domain.Blog;
import com.je.domain.repository.BlogRepo;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class BlogService {

    @Inject
    private BlogRepo blogRepo;

    public Blog create(CreateBlogRo ro) {
        Blog blog = new Blog(ro.getTitle(), ro.getContent());
        blogRepo.create(blog);
        return blog;
    }

    public List<Blog> list() {
        return blogRepo.list();
    }

}
