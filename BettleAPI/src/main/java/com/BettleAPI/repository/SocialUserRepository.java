package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
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

    public SocialUser findOneById(int givenId){
        return entityManager.createQuery("select a from SocialUser a where a.id =?1", SocialUser.class)
                .setParameter(1, givenId)
                .getSingleResult();
    }

    @Transactional
    public void updateSocialUser(int id, String email, String firstName, String gender, String lastName, String nationality){
        if(email != "") {
            entityManager.createQuery("update SocialUser a set a.email =?1 where a.id =?2")
                    .setParameter(1, email)
                    .setParameter(2, id)
                    .executeUpdate();
        }
        if(firstName != "") {
            entityManager.createQuery("update SocialUser a set a.firstName =?1 where a.id =?2")
                    .setParameter(1, firstName)
                    .setParameter(2, id)
                    .executeUpdate();
        }
        if(gender != "") {
            entityManager.createQuery("update SocialUser a set a.gender =?1 where a.id =?2")
                    .setParameter(1, gender)
                    .setParameter(2, id)
                    .executeUpdate();
        }
        if(lastName != "") {
            entityManager.createQuery("update SocialUser a set a.lastName =?1 where a.id =?2")
                    .setParameter(1, lastName)
                    .setParameter(2, id)
                    .executeUpdate();
        }
        if(nationality != "") {
            entityManager.createQuery("update SocialUser a set a.nationality =?1 where a.id =?2")
                    .setParameter(1, nationality)
                    .setParameter(2, id)
                    .executeUpdate();
        }
    }

    @Transactional
    public void deleteById(int id) {
        entityManager.createNativeQuery("DELETE FROM social_user WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
