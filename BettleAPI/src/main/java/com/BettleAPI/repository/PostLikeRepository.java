package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.PostLike;
import com.BettleAPI.entity.compositeId.PostLikeId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PostLikeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public PostLike save(PostLike postLike) {
        entityManager.createNativeQuery("INSERT INTO post_like (bet_slip_post_id, user_id) VALUES (?,?)")
                .setParameter(1, postLike.getId().getBetSlipPostId())
                .setParameter(2, postLike.getId().getUserId())
                .executeUpdate();
        return postLike;
    }

    @SuppressWarnings(value = "unchecked")
    public List<PostLike> findAll() {
        Query query = entityManager.createQuery("select a from PostLike a", PostLike.class);
        return query.getResultList();
    }

    public PostLike findOneById(int givenBetSlipPostId, int givenUserId){
        return entityManager.createQuery("select a from PostLike a where a.id.userId =?1 and a.id.betSlipPostId =?2", PostLike.class)
                .setParameter(1, givenUserId)
                .setParameter(2,givenBetSlipPostId)
                .getSingleResult();
    }

/*    public List<Integer> findLikedPostsByUserId(int userId){
        return entityManager.createQuery("select a.id.betSlipPostId from PostLike a where a.id.userId =?1")
                .setParameter(1, userId)
                .getResultList();
    }
*/
    public List<Integer> findUserIdsByLikedPostId(int postId){
        return entityManager.createQuery("select a.id.userId from PostLike a where a.id.betSlipPostId =?1")
                .setParameter(1, postId)
                .getResultList();
    }


    public void deleteById(PostLikeId id) {
        entityManager.createNativeQuery("DELETE FROM post_like WHERE bet_slip_post_id = ? AND user_id = ?")
                .setParameter(1, id.getBetSlipPostId())
                .setParameter(2, id.getUserId())
                .executeUpdate();
    }
}
