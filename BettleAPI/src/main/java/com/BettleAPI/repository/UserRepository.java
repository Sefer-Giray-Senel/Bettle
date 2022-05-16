package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.Subscribe;
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
        entityManager.createNativeQuery("INSERT INTO user (id, password, username) VALUES (?,?,?)")
                .setParameter(1, user.getId())
                .setParameter(2, user.getPassword())
                .setParameter(3, user.getUsername())
                .executeUpdate();
        return user;
    }

    @SuppressWarnings(value = "unchecked")
    public List<User> findAll() {
        Query query = entityManager.createQuery("select a from User a", User.class);
        return query.getResultList();
    }

    public User findOneById(int givenId){
        return entityManager.createQuery("select a from User a where a.id =?1", User.class)
                .setParameter(1, givenId)
                .getSingleResult();
    }

    public User findUserByUsername(String username){
        return entityManager.createQuery("select a from User a where a.username =?1", User.class)
                .setParameter(1, username)
                .getSingleResult();
    }

    public void deleteById(int id) {
        entityManager.createNativeQuery("DELETE FROM user WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }

    @Transactional
    public void updateUser(int id, String password, String username){
        if(username != "") {
            entityManager.createQuery("update User a set a.username =?1 where a.id =?2")
                    .setParameter(1, username)
                    .setParameter(2, id)
                    .executeUpdate();
        }
        if(password != "") {
            entityManager.createQuery("update User a set a.password =?1 where a.id =?2")
                    .setParameter(1, password)
                    .setParameter(2, id)
                    .executeUpdate();
        }
    }
}
