package com.BettleAPI.repository;


import com.BettleAPI.entity.Bet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BetRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Bet save(Bet bet) {
        entityManager.createNativeQuery("INSERT INTO bet (id, game_id, mbn, odd, title) VALUES (?,?,?,?,?)")
                .setParameter(1, bet.getId())
                .setParameter(2, bet.getGameId())
                .setParameter(3, bet.getMbn())
                .setParameter(4, bet.getOdd())
                .setParameter(5, bet.getTitle())
                .executeUpdate();
        return bet;
    }

    @SuppressWarnings(value = "unchecked") //FIX MEEEEEE-----------------------------------------------------------
    public Bet getById(UUID id) {
        Query query = entityManager.createQuery("select a from Bet a", Bet.class);
        Bet bet = ((Bet) query.getResultList().get(0));
        return bet;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Bet> findAll() {
        Query query = entityManager.createQuery("select a from Bet a", Bet.class);
        return query.getResultList();
    }

    public void deleteById(UUID id) {
        entityManager.createNativeQuery("DELETE FROM bet WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
