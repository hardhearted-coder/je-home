package com.je.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void testEquals() {
        Password pwd0 = new Password("pwd");
        Password pwd1 = new Password("PWD");
        Password pwd0BK = new Password("pwd");
        assertEquals(pwd0, pwd0);
        assertEquals(pwd0, pwd0BK);
        assertNotEquals(pwd0, pwd1);
    }

}