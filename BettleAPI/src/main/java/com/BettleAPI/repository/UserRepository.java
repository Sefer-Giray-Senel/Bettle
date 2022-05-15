package com.BettleAPI.repository;


import com.BettleAPI.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User save(User user) {
        entityManager.createNativeQuery("INSERT INTO user (id, password, token, username) VALUES (?,?,?,?)")
                .setParameter(1, user.getId())
                .setParameter(2, user.getPassword())
                .setParameter(3, user.getToken())
                .setParameter(4, user.getUsername())
                .executeUpdate();
        return user;
    }

    @SuppressWarnings(value = "unchecked")
    public List<User> findAll() {
        Query query = entityManager.createQuery("select a from User a", User.class);
        return query.getResultList();
    }

    public Optional<User> findUserByPassword(String username) { //---------------not correct
        User user = new User();
        return Optional.of(user);
    }

    public void deleteById(UUID id) {
        entityManager.createNativeQuery("DELETE FROM user WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
