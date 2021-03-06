package com.je.infrastructure.repository;

import com.je.domain.repository.TokenRepo;
import com.je.domain.Token;
import io.micronaut.data.annotation.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class TokenRepoImpl implements TokenRepo {

    @Inject
    private EntityManager entityManager;

    @Override
    public Optional<Token> find(String id) {
        return Optional.ofNullable(entityManager.find(Token.class, id));
    }

    @Override
    public Optional<Token> findByUid(long uid) {
        List<Token> tokens = entityManager.createQuery("select t from Token as t where uid = :uid", Token.class)
                .setParameter("uid", uid)
                .getResultList();
        if (tokens.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(tokens.get(0));
    }

    @Override
    public void create(Token token) {
        entityManager.createNativeQuery("insert into token (id, uid, expire) values (:id, :uid, :expire)")
                .setParameter("id", token.getId())
                .setParameter("uid", token.getUid())
                .setParameter("expire", token.getExpire())
                .executeUpdate();
    }

    @Override
    public void update(Token token) {
        entityManager.createNativeQuery("update token set (`value`, expire) values (:value, :expire) where uid = :uid")
                .setParameter("id", token.getId())
                .setParameter("uid", token.getUid())
                .setParameter("expire", token.getExpire())
                .executeUpdate();
    }

    @Override
    public void delete(Token token) {
        entityManager.createNativeQuery("delete from token where uid = :uid")
                .setParameter("uid", token.getUid())
                .executeUpdate();
    }

    @Override
    public int eliminate() {
        // todo
        return 0;
    }

}
