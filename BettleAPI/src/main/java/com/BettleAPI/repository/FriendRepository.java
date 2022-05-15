package com.BettleAPI.repository;


import com.BettleAPI.entity.Friend;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FriendRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Friend save(Friend friend) {
        /* sql statement */
        return friend;
    }
}
