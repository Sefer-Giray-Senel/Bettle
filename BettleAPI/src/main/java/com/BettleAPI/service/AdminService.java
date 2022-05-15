package com.BettleAPI.service;

import com.BettleAPI.entity.Admin;

import com.BettleAPI.repository.AdminRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class AdminService {
    private final AdminRepository adminRepository;

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public void delete(UUID id) {
        adminRepository.deleteById(id);
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

/*
    public Admin getByID(UUID id) { return adminRepository.getById(id);}

    public Long count() {
        return adminRepository.count();
    }
    */
}

