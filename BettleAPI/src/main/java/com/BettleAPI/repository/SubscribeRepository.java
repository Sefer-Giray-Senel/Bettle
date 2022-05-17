package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.Subscribe;
import com.BettleAPI.entity.compositeId.SubscribeId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SubscribeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Subscribe save(Subscribe subscribe) {
        entityManager.createNativeQuery("INSERT INTO subscribe (bettor_id, editor_id) VALUES (?,?)")
                .setParameter(1, subscribe.getId().getBettorId())
                .setParameter(2, subscribe.getId().getEditorId())
                .executeUpdate();
        return subscribe;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Subscribe> findAll() {
        Query query = entityManager.createQuery("select a from Subscribe a", Subscribe.class);
        return query.getResultList();
    }

    public Subscribe findOneById(int givenBettorId, int givenEditorId){
        return entityManager.createQuery("select a from Subscribe a where a.id.bettorId =?1 and a.id.editorId =?2", Subscribe.class)
                .setParameter(1, givenBettorId)
                .setParameter(2, givenEditorId)
                .getSingleResult();
    }

    public List<Integer> findSubscribedIdsByEditorId(int editorId){
        return entityManager.createQuery("select a.id.bettorId from Subscribe a where a.id.editorId =?1")
                .setParameter(1, editorId)
                .getResultList();
    }

    public List<Integer> findSubscribedEditorIdsByBettorId(int bettorId){
        return entityManager.createQuery("select a.id.editorId from Subscribe a where a.id.bettorId =?1")
                .setParameter(1, bettorId)
                .getResultList();
    }

    @Transactional
    public void deleteById(SubscribeId id) {
        entityManager.createNativeQuery("DELETE FROM subscribe WHERE bettor_id = ? AND editor_id = ?")
                .setParameter(1, id.getBettorId())
                .setParameter(2, id.getEditorId())
                .executeUpdate();
    }
}
