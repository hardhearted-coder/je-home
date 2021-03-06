package com.je.domain.repository;

import com.je.domain.Token;

import java.util.Optional;

public interface TokenRepo {

    Optional<Token> find(String id);

    Optional<Token> findByUid(long uid);

    void create(Token token);

    void update(Token token);

    void delete(Token token);

    int eliminate();

}
