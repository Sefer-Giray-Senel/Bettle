package com.BettleAPI.repository;

import com.BettleAPI.entity.BetSlip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface BetSlipRepository extends JpaRepository<BetSlip, UUID> {
}