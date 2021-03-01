package com.je.domain.valueobject;

import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void testNew() {
        BizException bizException = assertThrows(BizException.class, () -> new Password("pwd"));
        assertEquals(bizException.getCode(), CodeAndMessage.argIllegal.getCode());
        assertEquals(bizException.getMessage(), "length of password must gt 8");
    }

    @Test
    void testEquals() {
        Password pwd0 = new Password("test-password");
        Password pwd1 = new Password("TEST-PASSWORD");
        Password pwd0BK = new Password("test-password");
        assertEquals(pwd0, pwd0);
        assertEquals(pwd0, pwd0BK);
        assertNotEquals(pwd0, pwd1);
    }

}