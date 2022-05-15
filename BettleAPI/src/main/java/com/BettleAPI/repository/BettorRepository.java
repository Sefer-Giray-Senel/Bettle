package com.BettleAPI.repository;


import com.BettleAPI.entity.Bettor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class BettorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Bettor save(Bettor bettor) {
        entityManager.createNativeQuery("INSERT INTO bettor (id, balance, friend_count) VALUES (?,?,?)")
                .setParameter(1, bettor.getId())
                .setParameter(2, bettor.getBalance())
                .setParameter(3, bettor.getFriendCount())
                .executeUpdate();
        return bettor;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Bettor> findAll() {
        Query query = entityManager.createQuery("select a from Bettor a", Bettor.class);
        return query.getResultList();
    }

    public void deleteById(UUID id) {
        entityManager.createNativeQuery("DELETE FROM bettor WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
