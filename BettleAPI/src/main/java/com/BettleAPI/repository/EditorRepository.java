package com.BettleAPI.repository;


import com.BettleAPI.entity.Editor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EditorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Editor save(Editor editor) {
        /* sql statement */
        return editor;
    }
}
