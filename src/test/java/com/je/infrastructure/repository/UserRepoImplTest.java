package com.je.infrastructure.repository;

import com.je.domain.User;
import com.je.domain.repository.UserRepo;
import com.je.domain.valueobject.Password;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class UserRepoImplTest {

    @Inject
    private UserRepo userRepo;

    @Transactional
    @Test
    void saveAndFindAndUpdate() {
        // save
        User user = new User("test-name", new Password("ABCDEFGH"));
        userRepo.save(user);

        // find
        Optional<User> optionalUser = userRepo.findByName(user.getName());
        assertNotNull(optionalUser);
        assertTrue(optionalUser.isPresent());
        User actualUser = optionalUser.get();
        assertEquals(user.getId(), actualUser.getId());
        assertEquals(user.getPassword(), actualUser.getPassword());
        assertEquals(user.getName(), actualUser.getName());
        assertEquals(user.getPassword(), actualUser.getPassword());
        assertEquals(user.getRegisteredTime(), actualUser.getRegisteredTime());
    }

}