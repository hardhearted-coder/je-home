package com.je.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

    @Test
    void testNew() {
        Token token = new Token(12345678);
        assertNotNull(token.getId());
        assertEquals(token.getUid(), 12345678);
        assertNotNull(token.getExpire());
    }

}