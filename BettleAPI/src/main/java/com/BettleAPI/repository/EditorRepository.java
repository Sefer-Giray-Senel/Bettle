package com.BettleAPI.repository;


import com.BettleAPI.entity.Editor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class EditorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Editor save(Editor editor) {
        entityManager.createNativeQuery("INSERT INTO editor (id, subscriber_count, successful_bet_slip_count) VALUES (?,?,?)")
                .setParameter(1, editor.getId())
                .setParameter(2, editor.getSubscriberCount())
                .setParameter(3, editor.getSuccessfulBetSlipCount())
                .executeUpdate();
        return editor;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Editor> findAll() {
        Query query = entityManager.createQuery("select a from Editor a", Editor.class);
        return query.getResultList();
    }

    public void deleteById(UUID id) {
        entityManager.createNativeQuery("DELETE FROM editor WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
