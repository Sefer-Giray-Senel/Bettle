package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.GameComment;
import com.BettleAPI.entity.compositeId.GameCommentId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class GameCommentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public GameComment save(GameComment gameComment) {
        entityManager.createNativeQuery("INSERT INTO game_comment (match_id, user_id, comment) VALUES (?,?,?)")
                .setParameter(1, gameComment.getId().getMatchId())
                .setParameter(2, gameComment.getId().getUserId())
                .setParameter(3, gameComment.getComment())
                .executeUpdate();
        return gameComment;
    }

    @SuppressWarnings(value = "unchecked")
    public List<GameComment> findAll() {
        Query query = entityManager.createQuery("select a from GameComment a", GameComment.class);
        return query.getResultList();
    }

    public GameComment findOneById(int givenMatchId, int givenUserId){
        return entityManager.createQuery("select a from GameComment a where a.id.matchId =?1 and a.id.userId =?2", GameComment.class)
                .setParameter(1, givenMatchId)
                .setParameter(2, givenUserId)
                .getSingleResult();
    }

    public void deleteById(GameCommentId id) {
        entityManager.createNativeQuery("DELETE FROM game_comment WHERE match_id = ? AND user_id = ?")
                .setParameter(1, id.getMatchId())
                .setParameter(2, id.getUserId())
                .executeUpdate();
    }
}
