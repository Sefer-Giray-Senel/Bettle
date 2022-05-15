package com.BettleAPI.repository;


import com.BettleAPI.entity.SocialUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class SocialUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public SocialUser save(SocialUser socialUser) {
        entityManager.createNativeQuery("INSERT INTO social_user (" +
                "id, email, first_name, gender, is_banned, last_name, nationality)" +
                " VALUES (?,?,?,?,?,?,?)")
                .setParameter(1, socialUser.getId())
                .setParameter(2, socialUser.getEmail())
                .setParameter(3, socialUser.getFirstName())
                .setParameter(4, socialUser.getGender())
                .setParameter(5, socialUser.isBanned())
                .setParameter(6, socialUser.getLastName())
                .setParameter(7, socialUser.getNationality())
                .executeUpdate();
        return socialUser;
    }

    @SuppressWarnings(value = "unchecked")
    public List<SocialUser> findAll() {
        Query query = entityManager.createQuery("select a from SocialUser a", SocialUser.class);
        return query.getResultList();
    }

    public void deleteById(UUID id) {
        entityManager.createNativeQuery("DELETE FROM social_user WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
