package com.BettleAPI.repository;


import com.BettleAPI.entity.BettorHasSlip;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BettorHasSlipRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public BettorHasSlip save(BettorHasSlip bettorHasSlip) {
        /* sql statement */
        return bettorHasSlip;
    }
}
