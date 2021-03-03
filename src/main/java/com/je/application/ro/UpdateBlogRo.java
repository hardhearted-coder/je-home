package com.je.application.ro;

import lombok.Getter;

@Getter
public class UpdateBlogRo {

    private Long id;

    private String title;

    private String content;

    public UpdateBlogRo(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}
