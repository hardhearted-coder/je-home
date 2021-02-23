package com.je.application.ro;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class HealthTest {

    @Test
    void testEquals() {
        Instant now = Instant.now();
        Health hello0 = new Health("hello", now);
        Health hello1 = new Health("hello", now);
        assertEquals(hello0, hello1);
        Health world = new Health("world", now);
        assertNotEquals(hello0, world);
    }

}