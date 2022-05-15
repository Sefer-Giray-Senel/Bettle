package com.BettleAPI.repository;


import com.BettleAPI.entity.Bet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
