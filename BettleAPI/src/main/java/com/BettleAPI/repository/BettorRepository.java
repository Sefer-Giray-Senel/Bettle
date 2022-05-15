package com.BettleAPI.repository;


import com.BettleAPI.entity.Bettor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BettorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Bettor save(Bettor bettor) {
        /* sql statement */
        return bettor;
    }
}
