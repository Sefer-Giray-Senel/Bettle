package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.SlipComment;
import com.BettleAPI.entity.compositeId.PostLikeId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SlipCommentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public SlipComment save(SlipComment slipComment) {
        entityManager.createNativeQuery("INSERT INTO slip_comment (bet_slip_post_id, user_id, comment) VALUES (?,?,?)")
                .setParameter(1, slipComment.getId().getBetSlipPostId())
                .setParameter(2, slipComment.getId().getUserId())
                .setParameter(3, slipComment.getComment())
                .executeUpdate();
        return slipComment;
    }

    @SuppressWarnings(value = "unchecked")
    public List<SlipComment> findAll() {
        Query query = entityManager.createQuery("select a from SlipComment a", SlipComment.class);
        return query.getResultList();
    }

    public SlipComment findOneById(int givenBetSlipPostId, int givenUserId){
        return entityManager.createQuery("select a from SlipComment a where a.id.betSlipPostId =?1 and a.id.userId =?2", SlipComment.class)
                .setParameter(1, givenBetSlipPostId)
                .setParameter(2, givenUserId)
                .getSingleResult();
    }

    public List<SlipComment> findCommentsBySlipPostId(int betSlipPostId){
        return entityManager.createQuery("select a from SlipComment a where a.id.betSlipPostId =?1")
                .setParameter(1, betSlipPostId)
                .getResultList();
    }

    @Transactional
    public void deleteById(PostLikeId id) {
        entityManager.createNativeQuery("DELETE FROM slip_comment WHERE bet_slip_post_id = ? AND user_id = ?")
                .setParameter(1, id.getBetSlipPostId())
                .setParameter(2, id.getUserId())
                .executeUpdate();
    }
}
