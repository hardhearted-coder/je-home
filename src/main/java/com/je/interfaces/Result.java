package com.je.interfaces;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Result<T> {

    private Boolean success;

    private String code;

    private String message;

    private T data;

    public static Result<Void> ok() {
        Result<Void> result = new Result<>();
        result.success = true;
        result.setCodeAndMessage(CodeAndMessage.ok);
        return result;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.success = true;
        result.setCodeAndMessage(CodeAndMessage.ok);
        result.data = data;
        return result;
    }

    protected static Result<Void> error(CodeAndMessage codeAndMessage) {
        Result<Void> result = new Result<>();
        result.success = false;
        result.setCodeAndMessage(codeAndMessage);
        return result;
    }

    protected static Result<Void> error(CodeAndMessage codeAndMessage, String message) {
        Result<Void> error = error(codeAndMessage);
        error.message = message;
        return error;
    }

    protected static Result<Void> fromBizException(BizException bizException) {
        Result<Void> result = new Result<>();
        result.success = false;
        result.code = bizException.getCode();
        result.message = bizException.getMessage();
        return result;
    }

    private void setCodeAndMessage(@NonNull CodeAndMessage codeAndMessage) {
        code = codeAndMessage.getCode();
        message = codeAndMessage.getMessage();
    }

}
