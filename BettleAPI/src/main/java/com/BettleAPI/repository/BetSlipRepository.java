package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BetSlipRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public BetSlip save(BetSlip betSlip) {
        /* sql statement */
        return betSlip;
    }
}
