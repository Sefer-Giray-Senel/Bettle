package com.BettleAPI.repository;


import com.BettleAPI.entity.Edit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EditRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Edit save(Edit edit) {
        /* sql statement */
        return edit;
    }
}
