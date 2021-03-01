package com.je.domain.valueobject;

import com.je.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

    @Test
    void testNew() {
        User root = new User("root", new Password("test-password"));
        Token token = new Token(root);
        assertEquals(token.getUser(), root);
        assertNotNull(token.getToken());
        assertNotNull(token.getToken().getValue());
    }

}