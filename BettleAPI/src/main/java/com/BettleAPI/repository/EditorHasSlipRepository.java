package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.EditorHasSlip;
import com.BettleAPI.entity.compositeId.HasSlipId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EditorHasSlipRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public EditorHasSlip save(EditorHasSlip editorHasSlip) {
        entityManager.createNativeQuery("INSERT INTO editor_has_slip (bet_slip_id, user_id) VALUES (?,?)")
                .setParameter(1, editorHasSlip.getId().getBetSlipId())
                .setParameter(2, editorHasSlip.getId().getUserId())
                .executeUpdate();
        return editorHasSlip;
    }

    @SuppressWarnings(value = "unchecked")
    public List<EditorHasSlip> findAll() {
        Query query = entityManager.createQuery("select a from EditorHasSlip a", EditorHasSlip.class);
        return query.getResultList();
    }

    public EditorHasSlip findOneById(int givenUserId, int givenBetSlipId){
        return entityManager.createQuery("select a from EditorHasSlip a where a.id.userId =?1 and a.id.betSlipId =?2", EditorHasSlip.class)
                .setParameter(1, givenUserId)
                .setParameter(2, givenBetSlipId)
                .getSingleResult();
    }

    public List<Integer> findBetSlipIdsByEditorId(int userId){
        return entityManager.createQuery("select a.id.betSlipId from EditorHasSlip a where a.id.userId =?1")
                .setParameter(1, userId)
                .getResultList();
    }

    @Transactional
    public void deleteById(HasSlipId id) {
        entityManager.createNativeQuery("DELETE FROM editor_has_slip WHERE bet_slip_id = ? AND user_id = ?")
                .setParameter(1, id.getBetSlipId())
                .setParameter(2, id.getUserId())
                .executeUpdate();
    }
}
