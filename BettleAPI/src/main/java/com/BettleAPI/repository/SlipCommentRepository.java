package com.BettleAPI.repository;


import com.BettleAPI.entity.SlipComment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SlipCommentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public SlipComment save(SlipComment slipComment) {
        /* sql statement */
        return slipComment;
    }
}