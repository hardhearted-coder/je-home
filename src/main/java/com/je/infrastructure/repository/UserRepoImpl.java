package com.je.infrastructure.repository;

import com.je.domain.User;
import com.je.domain.repository.UserRepo;
import com.je.infrastructure.repository.po.UserPo;
import io.micronaut.data.annotation.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @Transactional must here, otherwise:
 * "Could not obtain transaction-synchronized Session for current thread"
 * <p>
 * entityManager.clear()
 * with not clear, `update` then `select`, the value of `select` will not be modified by `update`.
 */
@Repository
public class UserRepoImpl implements UserRepo {

    @Inject
    private EntityManager entityManager;

    @Override
    public Optional<User> find(long id) {
        return Optional.ofNullable(entityManager.find(UserPo.class, id)).map(UserPo::toDo);
    }

    @Override
    public Optional<User> findByName(String name) {
        List<UserPo> results = entityManager.createQuery("select u from UserPo as u where name = :name", UserPo.class)
                .setParameter("name", name).getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0).toDo());
    }

    @Override
    public void save(User user) {
        entityManager.persist(UserPo.fromDo(user));
    }

    @Override
    public void update(User user) {
        UserPo po = UserPo.fromDo(user);
        entityManager.createNativeQuery("update user set name = :name, password = :password, registered_time = :registered_time" +
                " where id = :id")
                .setParameter("name", po.getName())
                .setParameter("password", po.getPassword())
                .setParameter("registered_time", po.getRegisteredTime())
                .setParameter("id", po.getId())
                .executeUpdate();
    }

}
