package com.BettleAPI.repository;


import com.BettleAPI.entity.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.TransactionScoped;
import java.util.List;
import java.util.UUID;

@Repository
public class AdminRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Admin save(Admin admin) {
        entityManager.createNativeQuery("INSERT INTO admin (id, phone_number, salary) VALUES (?,?,?)")
                .setParameter(1, admin.getId())
                .setParameter(2, admin.getPhoneNumber())
                .setParameter(3, admin.getSalary())
                .executeUpdate();
        return admin;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Admin> findAll() {
        Query query = entityManager.createQuery("select a from Admin a", Admin.class);
        return query.getResultList();
    }

    public Admin findOneById(int givenId){
        return entityManager.createQuery("select a from Admin a where a.id =?1", Admin.class)
                .setParameter(1, givenId)
                .getSingleResult();
    }

    @Transactional
    public void updateAdmin(int id, String phoneNo) {
        if(phoneNo != "") {
            entityManager.createQuery("update Admin a set a.phoneNumber =?1 where a.id =?2")
                    .setParameter(1, phoneNo)
                    .setParameter(2, id)
                    .executeUpdate();
        }
    }

    @Transactional
    public void deleteById(int id) {
        entityManager.createNativeQuery("DELETE FROM admin WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
