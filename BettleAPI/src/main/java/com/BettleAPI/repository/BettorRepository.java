package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
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

    public Bettor findOneById(int givenId){
        return entityManager.createQuery("select a from Bettor a where a.id =?1", Bettor.class)
                .setParameter(1, givenId)
                .getSingleResult();
    }

    public void deleteById(int id) {
        entityManager.createNativeQuery("DELETE FROM bettor WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }

    public void updateBettor(int id, int balance, int friend_count) {
        if (balance != -1) {
            entityManager.createQuery("update Bettor a set a.balance =?1 where a.id =?2")
                    .setParameter(1, balance)
                    .setParameter(2, id)
                    .executeUpdate();
        }
        if(friend_count != -1) {
            entityManager.createQuery("update Bettor a set a.friendCount =?1 where a.id =?2")
                    .setParameter(1, friend_count)
                    .setParameter(2, id)
                    .executeUpdate();
        }
    }
}
