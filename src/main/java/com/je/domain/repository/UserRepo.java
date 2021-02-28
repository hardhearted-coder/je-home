package com.je.domain.repository;

import com.je.domain.User;
import com.je.domain.valueobject.Password;
import io.micronaut.data.annotation.Repository;

import java.util.Optional;

@Repository
public class UserRepo {

    public Optional<User> find(String name) {
        return Optional.ofNullable(new User(name, new Password(name)));
    }

}
