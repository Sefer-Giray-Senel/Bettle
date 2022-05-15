package com.BettleAPI.repository;


import com.BettleAPI.entity.Subscribe;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SubscribeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Subscribe save(Subscribe subscribe) {
        /* sql statement */
        return subscribe;
    }
}
