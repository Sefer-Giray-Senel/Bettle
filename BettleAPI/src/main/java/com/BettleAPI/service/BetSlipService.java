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

    public BetSlip findOneById(int id) { return betSlipRepository.findOneById(id);}

    public void updateBetSlip(int id, double odd, boolean shared) { betSlipRepository.updateBetSlip(id, odd, shared); }

    public List<BetSlip> findBetSlipsByShared(int id, boolean shared) {
        return betSlipRepository.findBetSlipsByShared(id, shared);
    }
}

