package com.je.application.service;

import com.je.application.ro.UpdateBlogRo;
import com.je.domain.Blog;
import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class BlogServiceTest {

    @Inject
    private BlogService blogService;

    @Test
    void update() {
        BizException bizException;

        UpdateBlogRo idNullRo = new UpdateBlogRo(null, "", "");
        bizException = assertThrows(BizException.class, () -> blogService.update(idNullRo));
        assertEquals(bizException.getCode(), CodeAndMessage.argIllegal.getCode());
        assertEquals(bizException.getMessage(), "id can not be null");

        UpdateBlogRo titleBlankRo = new UpdateBlogRo(1L, "", "");
        bizException = assertThrows(BizException.class, () -> blogService.update(titleBlankRo));
        assertEquals(bizException.getCode(), CodeAndMessage.argIllegal.getCode());
        assertEquals(bizException.getMessage(), "title can not be blank");

        UpdateBlogRo contentBlankRo = new UpdateBlogRo(1L, "x", "");
        bizException = assertThrows(BizException.class, () -> blogService.update(contentBlankRo));
        assertEquals(bizException.getCode(), CodeAndMessage.argIllegal.getCode());
        assertEquals(bizException.getMessage(), "content can not be blank");

        UpdateBlogRo idNotFoundRo = new UpdateBlogRo(-1L, "x", "y");
        bizException = assertThrows(BizException.class, () -> blogService.update(idNotFoundRo));
        assertEquals(bizException.getCode(), CodeAndMessage.argIllegal.getCode());
        assertEquals(bizException.getMessage(), "id not found");

        UpdateBlogRo successRo = new UpdateBlogRo(1L, "x", "y");
        Blog blog = blogService.update(successRo);
        assertEquals(successRo.getTitle(), blog.getTitle());
        assertEquals(successRo.getContent(), blog.getContent());
    }

}