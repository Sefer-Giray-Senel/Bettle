package com.BettleAPI.repository;


import com.BettleAPI.entity.GameComment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GameCommentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public GameComment save(GameComment gameComment) {
        /* sql statement */
        return gameComment;
    }
}
