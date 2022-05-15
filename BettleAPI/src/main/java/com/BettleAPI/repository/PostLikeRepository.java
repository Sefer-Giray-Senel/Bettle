package com.BettleAPI.repository;


import com.BettleAPI.entity.PostLike;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostLikeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public PostLike save(PostLike postLike) {
        /* sql statement */
        return postLike;
    }
}
