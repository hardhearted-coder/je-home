package com.je.interfaces;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BizException extends RuntimeException {

    private final String code;

    private final String message;

    public BizException(CodeAndMessage codeAndMessage) {
        this.code = codeAndMessage.getCode();
        this.message = codeAndMessage.getMessage();
    }

    public BizException(CodeAndMessage codeAndMessage, String message) {
        this.code = codeAndMessage.getCode();
        this.message = message;
    }

}
