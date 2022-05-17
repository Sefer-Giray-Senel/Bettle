package com.BettleAPI.repository;


import com.BettleAPI.entity.Admin;
import com.BettleAPI.entity.Bans;
import com.BettleAPI.entity.compositeId.BansId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BansRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Bans save(Bans bans) {
        entityManager.createNativeQuery("INSERT INTO bans (admin_id, social_user_id, ban_reason, date) VALUES (?,?,?,?)")
                .setParameter(1, bans.getId().getAdminId())
                .setParameter(2, bans.getId().getSocialUserId())
                .setParameter(3, bans.getBanReason())
                .setParameter(4, bans.getDate())
                .executeUpdate();
        return bans;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Bans> findAll() {
        Query query = entityManager.createQuery("select a from Bans a", Bans.class);
        return query.getResultList();
    }

    public Bans findOneById(int givenAdminId, int givenSocialUserId){
        return entityManager.createQuery("select a from Bans a where a.id.adminId =?1 and a.id.socialUserId =?2", Bans.class)
                .setParameter(1, givenAdminId)
                .setParameter(2, givenSocialUserId)
                .getSingleResult();
    }

    public Integer findAdminIdByBannedUser(int userId){
        return (Integer) entityManager.createQuery("select a.id.adminId from Bans a where a.id.socialUserId =?1")
                .setParameter(1, userId)
                .getSingleResult();
    }

    @Transactional
    public void deleteById(BansId id) {
        entityManager.createNativeQuery("DELETE FROM bans WHERE admin_id = ? AND social_user_id = ?")
                .setParameter(1, id.getAdminId())
                .setParameter(2, id.getSocialUserId())
                .executeUpdate();
    }
}
