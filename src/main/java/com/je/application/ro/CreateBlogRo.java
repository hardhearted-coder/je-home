package com.je.application.ro;

import lombok.Getter;

@Getter
public class CreateBlogRo {

    private String title;

    private String content;

    /**
     * default constructor will be used by Controller
     */
    public CreateBlogRo() {
    }

}
