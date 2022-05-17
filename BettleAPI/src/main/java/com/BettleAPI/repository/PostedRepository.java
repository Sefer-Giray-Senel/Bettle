package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.PostLike;
import com.BettleAPI.entity.Posted;
import com.BettleAPI.entity.compositeId.PostLikeId;
import com.BettleAPI.entity.compositeId.PostedId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PostedRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Posted save(Posted posted) {
        entityManager.createNativeQuery("INSERT INTO posted (bet_slip_post_id, bet_slip_id, user_id) VALUES (?,?,?)")
                .setParameter(1, posted.getId().getBetSlipPostId())
                .setParameter(2, posted.getId().getBetSlipId())
                .setParameter(3,posted.getId().getUserId())
                .executeUpdate();
        return posted;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Posted> findAll() {
        Query query = entityManager.createQuery("select a from Posted a", PostLike.class);
        return query.getResultList();
    }

    public Posted findOneById(int givenBetSlipPostId, int givenBetSlipId, int givenUserId){
        return entityManager.createQuery("select a from Posted a where a.id.userId =?1 and a.id.betSlipId =?2 and a.id.betSlipPostId =?3", Posted.class)
                .setParameter(1, givenUserId)
                .setParameter(2,givenBetSlipId)
                .setParameter(3,givenBetSlipPostId)
                .getSingleResult();
    }

    @Transactional
    public void deleteById(PostedId id) {
        entityManager.createNativeQuery("DELETE FROM Posted WHERE bet_slip_post_id = ? AND bet_slip_id = ? AND user_id = ?")
                .setParameter(1, id.getBetSlipPostId())
                .setParameter(2, id.getBetSlipId())
                .setParameter(3, id.getUserId())
                .executeUpdate();
    }

    public List<Integer> findAllBetSlipsByUserId(int givenUserId){
        return entityManager.createQuery("select a.id.betSlipId from Posted a where a.id.userId =?1")
                .setParameter(1, givenUserId)
                .getResultList();
    }

    public List<Integer> findAllBetSlipPostsByUserId(int givenUserId){
        return entityManager.createQuery("select a.id.betSlipPostId from Posted a where a.id.userId =?1")
                .setParameter(1, givenUserId)
                .getResultList();
    }

    public Integer findPostFromBetSlipId(int betSlipId){
        return (Integer) entityManager.createQuery("select a.id.betSlipPostId from Posted a where a.id.betSlipId =?1")
                .setParameter(1,betSlipId)
                .getSingleResult();
    }

    public Posted findPostedByBetSlipPostIdAndUserId(int givenBetSlipPostId, int givenUserId){
        return entityManager.createQuery("select a from Posted a where a.id.userId =?1 and a.id.betSlipPostId =?2", Posted.class)
                .setParameter(1, givenUserId)
                .setParameter(2,givenBetSlipPostId)
                .getSingleResult();
    }
}
