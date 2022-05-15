package com.BettleAPI.repository;


import com.BettleAPI.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User save(User user) {
        /* sql statement */
        return user;
    }

    public Optional<User> findUserByPassword(String username) { //not correct
        User user = new User();
        return Optional.of(user);
    }
}
