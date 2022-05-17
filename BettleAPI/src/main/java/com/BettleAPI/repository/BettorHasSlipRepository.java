package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.BettorHasSlip;
import com.BettleAPI.entity.compositeId.HasSlipId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BettorHasSlipRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public BettorHasSlip save(BettorHasSlip bettorHasSlip) {
        entityManager.createNativeQuery("INSERT INTO bettor_has_slip (bet_slip_id, user_id, placed_cash) VALUES (?,?,?)")
                .setParameter(1, bettorHasSlip.getId().getBetSlipId())
                .setParameter(2, bettorHasSlip.getId().getUserId())
                .setParameter(3, bettorHasSlip.getPlacedCash())
                .executeUpdate();
        return bettorHasSlip;
    }

    @SuppressWarnings(value = "unchecked")
    public List<BettorHasSlip> findAll() {
        Query query = entityManager.createQuery("select a from BettorHasSlip a", BettorHasSlip.class);
        return query.getResultList();
    }

    public BettorHasSlip findOneById(int givenBetSlipId, int givenUserId){
        return entityManager.createQuery("select a from BettorHasSlip a where a.id.betSlipId =?1 and a.id.userId =?2", BettorHasSlip.class)
                .setParameter(1, givenBetSlipId)
                .setParameter(2, givenUserId)
                .getSingleResult();
    }

    public List<Integer> findBetSlipIdByUserId(int userId){
        return entityManager.createQuery("select a.id.betSlipId from BettorHasSlip a where a.id.userId =?1")
                .setParameter(1, userId)
                .getResultList();
    }

    @Transactional
    public void deleteById(HasSlipId id) {
        entityManager.createNativeQuery("DELETE FROM bettor_has_slip WHERE bet_slip_id = ? AND user_id = ?")
                .setParameter(1, id.getBetSlipId())
                .setParameter(2, id.getUserId())
                .executeUpdate();
    }
}
