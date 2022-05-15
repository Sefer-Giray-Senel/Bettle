package com.BettleAPI.repository;


import com.BettleAPI.entity.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AdminRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Admin save(Admin admin) {
        /* sql statement */
        return admin;
    }
}
