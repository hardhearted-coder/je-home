package com.je.domain;

import com.je.domain.valueobject.Password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testNew() {
        User root = new User("root", new Password("pwd"));
        assertNotNull(root.getId());
        assertNotNull(root.getName());
        assertNotNull(root.getPassword());
        assertNotNull(root.getRegisteredTime());
    }

    @Test
    void testCanLogin() {
        User root = new User("root", new Password("pwd"));
        assertTrue(root.canLogin(root.getPassword()));
        assertTrue(root.canLogin(new Password("pwd")));
        assertFalse(root.canLogin(new Password("PWD")));
    }

}