package com.BettleAPI.service;

import com.BettleAPI.entity.BettorHasSlip;

import com.BettleAPI.repository.BettorHasSlipRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BettorHasSlipService {
    private final BettorHasSlipRepository bettorHasSlipRepository;

    public BettorHasSlip save(BettorHasSlip bettorHasSlip) {
        return bettorHasSlipRepository.save(bettorHasSlip);
    }
/*
    public void delete(UUID id) {
        bettorHasSlipRepository.deleteById(id);
    }

    public List<BettorHasSlip> findAll() {
        return bettorHasSlipRepository.findAll();
    }

    public BettorHasSlip getByID(UUID id) { return bettorHasSlipRepository.getById(id);}

    public Long count() {
        return bettorHasSlipRepository.count();
    }

 */
}

