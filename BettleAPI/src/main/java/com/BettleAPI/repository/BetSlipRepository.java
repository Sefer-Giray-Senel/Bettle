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
        entityManager.createNativeQuery("INSERT INTO bet_slip (id, odd) VALUES (?,?)")
                .setParameter(1, betSlip.getId())
                .setParameter(2, betSlip.getOdd())
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

    public void deleteById(int id) {
        entityManager.createNativeQuery("DELETE FROM bet_slip WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
