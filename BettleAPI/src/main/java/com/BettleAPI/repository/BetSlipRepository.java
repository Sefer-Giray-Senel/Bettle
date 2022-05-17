package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.BetSlipPost;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class BetSlipRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public BetSlip save(BetSlip betSlip) {
        entityManager.createNativeQuery("INSERT INTO bet_slip (id, odd, shared) VALUES (?,?,?)")
                .setParameter(1, betSlip.getId())
                .setParameter(2, betSlip.getOdd())
                .setParameter(3,betSlip.isShared())
                .executeUpdate();
        return betSlip;
    }

    @SuppressWarnings(value = "unchecked")
    public List<BetSlip> findAll() {
        Query query = entityManager.createQuery("select a from BetSlip a", BetSlip.class);
        return query.getResultList();
    }

    public BetSlip findOneById(int givenId){
        return entityManager.createQuery("select a from BetSlip a where a.id =?1", BetSlip.class)
                .setParameter(1, givenId)
                .getSingleResult();
    }

    @Transactional
    public void deleteById(int id) {
        entityManager.createNativeQuery("DELETE FROM bet_slip WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }

    @Transactional
    public void updateBetSlip(int id, double odd, boolean shared) {
        if (odd != -1) {
            entityManager.createQuery("update BetSlip a set a.odd =?1 where a.id =?2")
                    .setParameter(1, odd)
                    .setParameter(2, id)
                    .executeUpdate();
            entityManager.createQuery("update BetSlip a set a.shared =?1 where a.id =?2")
                    .setParameter(1, shared)
                    .setParameter(2, id)
                    .executeUpdate();
        }
    }

    public List<BetSlip> findBetSlipsByShared(int id, boolean shared) {
        Query query = entityManager.createQuery("select a from BetSlip a where a.shared = ?1 and a.id = ?2", BetSlip.class)
                    .setParameter(1, shared)
                    .setParameter(2, id);
        return query.getResultList();
    }
}
