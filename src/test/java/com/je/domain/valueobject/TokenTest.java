package com.je.domain.valueobject;

import com.je.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

    @Test
    void testNew() {
        User root = new User("root", new Password("pwd"));
        Token token = new Token(root);
        assertEquals(token.getUserId(), root.getId());
        assertNotNull(token.getValue());
    }

}