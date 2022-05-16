package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.Edit;
import com.BettleAPI.entity.compositeId.EditId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EditRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Edit save(Edit edit) {
        entityManager.createNativeQuery("INSERT INTO edit (bet_id, user_id) VALUES (?,?)")
                .setParameter(1, edit.getId().getBetId())
                .setParameter(2, edit.getId().getUserId())
                .executeUpdate();
        return edit;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Edit> findAll() {
        Query query = entityManager.createQuery("select a from Edit a", Edit.class);
        return query.getResultList();
    }

    public Edit findOneById(int givenBetId, int givenUserId){
        return entityManager.createQuery("select a from Edit a where a.id.userId =?1 and a.id.betId =?2", Edit.class)
                .setParameter(1, givenUserId)
                .setParameter(2, givenBetId)
                .getSingleResult();
    }

    public List<Integer> findBetIdByUserId(int userId){
        return entityManager.createQuery("select a.id.betId from Edit a where a.id.userId =?1")
                .setParameter(1, userId)
                .getResultList();
    }

    public void deleteById(EditId id) {
        entityManager.createNativeQuery("DELETE FROM edit WHERE bet_id = ? AND user_id = ?")
                .setParameter(1, id.getBetId())
                .setParameter(2, id.getUserId())
                .executeUpdate();
    }
}
