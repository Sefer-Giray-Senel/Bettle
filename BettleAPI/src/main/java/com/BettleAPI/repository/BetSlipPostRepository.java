package com.BettleAPI.repository;


import com.BettleAPI.entity.Bans;
import com.BettleAPI.entity.BetSlipPost;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class BetSlipPostRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public BetSlipPost save(BetSlipPost betSlipPost) {
        entityManager.createNativeQuery("INSERT INTO bet_slip_post (id, post_text, test_count) VALUES (?,?)")
                .setParameter(1, betSlipPost.getId())
                .setParameter(2, betSlipPost.getPostText())
                .executeUpdate();
        return betSlipPost;
    }

    @SuppressWarnings(value = "unchecked")
    public List<BetSlipPost> findAll() {
        Query query = entityManager.createQuery("select a from BetSlipPost a", BetSlipPost.class);
        return query.getResultList();
    }

    /*
    public List<BetSlipPost> findBetSlipPostsOfFriendsByUserId(int userId) {
        Query query = entityManager.createQuery("select a from BetSlipPost a join Posted p where p.id.userId in (select b.id.secondBettorId from Friend b where b.id.firstBettorId = ?1)", BetSlipPost.class)
                        .setParameter(1, userId);
        return query.getResultList();
    }

     */

    public BetSlipPost findOneById(int givenId){
        return entityManager.createQuery("select a from BetSlipPost a where a.id =?1", BetSlipPost.class)
                .setParameter(1, givenId)
                .getSingleResult();
    }

    @Transactional
    public void deleteById(int id) {
        entityManager.createNativeQuery("DELETE FROM bet_slip_post WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
