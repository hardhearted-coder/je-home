package com.je.domain;

import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlogTest {

    @Test
    void testNew() {
        BizException titleIsBlank = assertThrows(BizException.class, () -> new Blog("", ""));
        assertEquals(titleIsBlank.getCode(), CodeAndMessage.argIllegal.getCode());
        assertEquals(titleIsBlank.getMessage(), "title is blank");

        BizException contentIsBlank = assertThrows(BizException.class, () -> new Blog("not blank", ""));
        assertEquals(contentIsBlank.getCode(), CodeAndMessage.argIllegal.getCode());
        assertEquals(contentIsBlank.getMessage(), "content is blank");

        Blog blog = new Blog("title test", "content test");
        assertNotNull(blog.getId());
        assertNotNull(blog.getTitle());
        assertNotNull(blog.getContent());
        assertNotNull(blog.getCreatedTime());
    }

}