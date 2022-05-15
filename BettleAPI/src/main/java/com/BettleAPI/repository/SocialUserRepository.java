package com.BettleAPI.repository;


import com.BettleAPI.entity.SocialUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SocialUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public SocialUser save(SocialUser socialUser) {
        /* sql statement */
        return socialUser;
    }
}
