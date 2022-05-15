package com.BettleAPI.repository;


import com.BettleAPI.entity.Game;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GameRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Game save(Game game) {
        /* sql statement */
        return game;
    }
}
