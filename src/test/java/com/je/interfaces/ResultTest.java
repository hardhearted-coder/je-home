package com.je.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void testOk() {
        Result<Void> ok0 = Result.ok();
        assertTrue(ok0.getSuccess());
        assertEquals(ok0.getCode(), CodeAndMessage.ok.getCode());
        assertEquals(ok0.getMessage(), CodeAndMessage.ok.getMessage());
        assertNull(ok0.getData());
        Result<String> hello = Result.ok("hello");
        assertTrue(hello.getSuccess());
        assertEquals(hello.getCode(), CodeAndMessage.ok.getCode());
        assertEquals(hello.getMessage(), CodeAndMessage.ok.getMessage());
        assertEquals(hello.getData(), "hello");
    }

    @Test
    void testError() {
        Result<Void> error = Result.error(CodeAndMessage.error, "hello, error");
        assertFalse(error.getSuccess());
        assertEquals(error.getCode(), CodeAndMessage.error.getCode());
        assertEquals(error.getMessage(), "hello, error");
        assertNull(error.getData());
        Result<Void> apiNotExist = Result.error(CodeAndMessage.apiNotExist);
        assertFalse(apiNotExist.getSuccess());
        assertEquals(apiNotExist.getCode(), CodeAndMessage.apiNotExist.getCode());
        assertEquals(apiNotExist.getMessage(), CodeAndMessage.apiNotExist.getMessage());
        assertNull(apiNotExist.getData());
    }

    @Test
    void fromBizException() {
        Result<Void> result = Result.fromBizException(new BizException(CodeAndMessage.error, "hello, error"));
        assertFalse(result.getSuccess());
        assertEquals(result.getCode(), CodeAndMessage.error.getCode());
        assertEquals(result.getMessage(), "hello, error");
        assertNull(result.getData());
    }

}