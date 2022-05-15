package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlipPost;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BetSlipPostRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public BetSlipPost save(BetSlipPost betSlipPost) {
        /* sql statement */
        return betSlipPost;
    }
}
