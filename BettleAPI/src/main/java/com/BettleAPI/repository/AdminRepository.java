package com.BettleAPI.repository;

import com.BettleAPI.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin, UUID> {
}