package com.je.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BizExceptionTest {

    @Test
    void testNew() {
        BizException apiNotExist = new BizException(CodeAndMessage.apiNotExist);
        assertEquals(apiNotExist.getCode(), CodeAndMessage.apiNotExist.getCode());
        assertEquals(apiNotExist.getMessage(), CodeAndMessage.apiNotExist.getMessage());
        BizException error = new BizException(CodeAndMessage.error, "hello, error");
        assertEquals(error.getCode(), CodeAndMessage.error.getCode());
        assertEquals(error.getMessage(), "hello, error");
    }

}