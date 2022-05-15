package com.BettleAPI.repository;


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
        entityManager.createNativeQuery("INSERT INTO bet_slip_post (id, test_count) VALUES (?,?)")
                .setParameter(1, betSlipPost.getId())
                .setParameter(2, betSlipPost.getTest_count()) //TEMPORARY
                .executeUpdate();
        return betSlipPost;
    }

    @SuppressWarnings(value = "unchecked")
    public List<BetSlipPost> findAll() {
        Query query = entityManager.createQuery("select a from BetSlipPost a", BetSlipPost.class);
        return query.getResultList();
    }

    public void deleteById(UUID id) {
        entityManager.createNativeQuery("DELETE FROM bet_slip_post WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
