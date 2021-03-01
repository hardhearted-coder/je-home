package com.je.domain.repository;

import com.je.domain.User;
import com.je.domain.valueobject.Password;
import io.micronaut.data.annotation.Repository;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Repository
public class UserRepo {

    public Optional<User> find(String name) {
        return Optional.ofNullable(new User(name, new Password(name)));
    }

    public void update(User user) {
        log.info("updated success, {}", user);
    }

}
