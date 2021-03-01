package com.je.domain;

import com.je.domain.valueobject.Password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testNew() {
        User root = new User("root", new Password("test-password"));
        assertNotNull(root.getId());
        assertNotNull(root.getName());
        assertNotNull(root.getPassword());
        assertNotNull(root.getRegisteredTime());
    }

    @Test
    void testCanLogin() {
        User root = new User("root", new Password("test-password"));
        assertTrue(root.canLogin(root.getPassword()));
        assertTrue(root.canLogin(new Password("test-password")));
        assertFalse(root.canLogin(new Password("TEST-PASSWORD")));
    }

    @Test
    void testResetPassword() {
        User root = new User("root", new Password("test-password"));
        Password newPassword = new Password("new-password");
        root.resetPassword(newPassword);
        assertEquals(root.getPassword(), newPassword);
    }

}