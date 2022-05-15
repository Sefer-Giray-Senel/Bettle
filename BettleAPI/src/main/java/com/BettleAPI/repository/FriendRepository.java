package com.BettleAPI.repository;


import com.BettleAPI.entity.Friend;
import com.BettleAPI.entity.compositeId.FriendId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class FriendRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Friend save(Friend friend) {
        entityManager.createNativeQuery("INSERT INTO friend (first_bettor_id, second_bettor_id) VALUES (?,?)")
                .setParameter(1, friend.getId().getFirstBettorId())
                .setParameter(2, friend.getId().getSecondBettorId())
                .executeUpdate();
        return friend;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Friend> findAll() {
        Query query = entityManager.createQuery("select a from Friend a", Friend.class);
        return query.getResultList();
    }

    public void deleteById(FriendId id) {
        entityManager.createNativeQuery("DELETE FROM friend WHERE first_bettor_id = ? AND second_bettor_id = ?")
                .setParameter(1, id.getFirstBettorId())
                .setParameter(2, id.getSecondBettorId())
                .executeUpdate();
    }
}
