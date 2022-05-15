package com.BettleAPI.repository;


import com.BettleAPI.entity.Bans;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BansRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Bans save(Bans bans) {
        /* sql statement */
        return bans;
    }
}
