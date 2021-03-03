package com.je.application.service;

import cn.hutool.core.util.StrUtil;
import com.je.application.ro.CreateBlogRo;
import com.je.application.ro.UpdateBlogRo;
import com.je.domain.Blog;
import com.je.domain.repository.BlogRepo;
import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class BlogService {

    @Inject
    private BlogRepo blogRepo;

    public Blog create(CreateBlogRo ro) {
        Blog blog = new Blog(ro.getTitle(), ro.getContent());
        blogRepo.create(blog);
        return blog;
    }

    public Blog update(UpdateBlogRo ro) {
        if (ro.getId() == null) {
            throw new BizException(CodeAndMessage.argIllegal, "id can not be null");
        }
        if (StrUtil.isBlank(ro.getTitle())) {
            throw new BizException(CodeAndMessage.argIllegal, "title can not be blank");
        }
        if (StrUtil.isBlank(ro.getContent())) {
            throw new BizException(CodeAndMessage.argIllegal, "content can not be blank");
        }
        return blogRepo.find(ro.getId())
                .map(blog -> {
                    blog.setTitle(ro.getTitle());
                    blog.setContent(ro.getContent());
                    blogRepo.update(blog);
                    return blog;
                })
                .orElseThrow(() -> new BizException(CodeAndMessage.argIllegal, "id not found"));
    }

    public Optional<Blog> find(long id) {
        return blogRepo.find(id);
    }

    public List<Blog> list() {
        return blogRepo.list();
    }

}
