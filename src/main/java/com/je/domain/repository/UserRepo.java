package com.je.domain.repository;

import com.je.domain.User;

import java.util.Optional;

public interface UserRepo {

    Optional<User> find(long id);

    Optional<User> findByName(String name);

    void save(User user);

    void update(User user);

}
