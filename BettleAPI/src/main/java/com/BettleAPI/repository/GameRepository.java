package com.BettleAPI.repository;


import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.entity.Game;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class GameRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Game save(Game game) {
        entityManager.createNativeQuery("INSERT INTO game (id, date, first_team_name, second_team_name) VALUES (?,?,?,?)")
                .setParameter(1, game.getId())
                .setParameter(2, game.getDate())
                .setParameter(3, game.getFirstTeamName())
                .setParameter(4, game.getSecondTeamName())
                .executeUpdate();
        return game;
    }

    @SuppressWarnings(value = "unchecked")
    public List<Game> findAll() {
        Query query = entityManager.createQuery("select a from Game a", Game.class);
        return query.getResultList();
    }

    public Game findOneById(int givenId){
        return entityManager.createQuery("select a from Game a where a.id =?1", Game.class)
                .setParameter(1, givenId)
                .getSingleResult();
    }

    public void deleteById(int id) {
        entityManager.createNativeQuery("DELETE FROM game WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
