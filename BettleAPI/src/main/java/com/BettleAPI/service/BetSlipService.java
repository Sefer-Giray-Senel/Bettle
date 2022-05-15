package com.BettleAPI.service;

import com.BettleAPI.entity.BetSlip;

import com.BettleAPI.repository.BetSlipRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BetSlipService {
    private final BetSlipRepository betSlipRepository;

    public BetSlip save(BetSlip betSlip) {
        return betSlipRepository.save(betSlip);
    }

    public void delete(int id) {
        betSlipRepository.deleteById(id);
    }

    public List<BetSlip> findAll() {
        return betSlipRepository.findAll();
    }
/*
    public BetSlip getByID(UUID id) { return betSlipRepository.getById(id);}

    public Long count() {
        return betSlipRepository.count();
    }

 */
}

