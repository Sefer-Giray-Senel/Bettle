package com.BettleAPI.repository;


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

    public void deleteById(SubscribeId id) {
        entityManager.createNativeQuery("DELETE FROM subscribe WHERE bettor_id = ? AND editor_id = ?")
                .setParameter(1, id.getBettorId())
                .setParameter(2, id.getEditorId())
                .executeUpdate();
    }
}
