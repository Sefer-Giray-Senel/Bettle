package com.BettleAPI.repository;

import com.BettleAPI.entity.BetSlipPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface BetSlipPostRepository extends JpaRepository<BetSlipPost, UUID> {
}