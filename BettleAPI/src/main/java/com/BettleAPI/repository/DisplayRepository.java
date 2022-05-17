package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.Display;
import com.BettleAPI.entity.compositeId.DisplayId;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DisplayRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Display save(Display display) {
        entityManager.createNativeQuery("INSERT INTO display (bet_id, bet_slip_id, has_odd) VALUES (?,?,?)")
                .setParameter(1, display.getId().getBetId())
                .setParameter(2, display.getId().getBetSlipId())
                .setParameter(3, display.getHasOdd())
                .executeUpdate();
        return display;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Display> findAll() {
        Query query = entityManager.createQuery("select a from Display a", Display.class);
        return query.getResultList();
    }

    public Display findOneById(int givenBetId, int givenBetSlipId){
        return entityManager.createQuery("select a from Display a where a.id.betSlipId =?1 and a.id.betId =?2", Display.class)
                .setParameter(1, givenBetSlipId)
                .setParameter(2, givenBetId)
                .getSingleResult();
    }

    public List<Integer> findBetsByBetSlipId(int betSlipId){
        return entityManager.createQuery("select a.id.betId from Display a where a.id.betSlipId =?1")
                .setParameter(1, betSlipId)
                .getResultList();
    }

    public List<Display> findDisplaysByBetSlipId(int betSlipId) {
        Query query = entityManager.createQuery("select a from Display a where a.id.betSlipId=?1", Display.class)
                    .setParameter(1, betSlipId);
        return query.getResultList();
    }

    @Transactional
    public void deleteById(DisplayId id) {
        entityManager.createNativeQuery("DELETE FROM display WHERE bet_id = ? AND bet_slip_id = ?")
                .setParameter(1, id.getBetId())
                .setParameter(2, id.getBetSlipId())
                .executeUpdate();
    }
}
