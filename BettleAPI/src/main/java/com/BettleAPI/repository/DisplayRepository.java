package com.BettleAPI.repository;


import com.BettleAPI.entity.Display;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DisplayRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Display save(Display display) {
        /* sql statement */
        return display;
    }
}
