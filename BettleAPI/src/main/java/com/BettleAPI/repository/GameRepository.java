package com.BettleAPI.repository;

import com.BettleAPI.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface GameRepository extends JpaRepository<Game, UUID> {
}