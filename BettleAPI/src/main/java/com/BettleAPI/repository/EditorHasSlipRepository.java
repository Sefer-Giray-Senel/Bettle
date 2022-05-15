package com.BettleAPI.repository;


import com.BettleAPI.entity.EditorHasSlip;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EditorHasSlipRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public EditorHasSlip save(EditorHasSlip editorHasSlip) {
        /* sql statement */
        return editorHasSlip;
    }
}
