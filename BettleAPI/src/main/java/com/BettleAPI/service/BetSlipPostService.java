package com.BettleAPI.service;

import com.BettleAPI.entity.BetSlipPost;

import com.BettleAPI.repository.BetSlipPostRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BetSlipPostService {
    private final BetSlipPostRepository betSlipPostRepository;

    public BetSlipPost save(BetSlipPost betSlipPost) {
        return betSlipPostRepository.save(betSlipPost);
    }

    public void delete(int id) {
        betSlipPostRepository.deleteById(id);
    }

    public List<BetSlipPost> findAll() {
        return betSlipPostRepository.findAll();
    }

    public BetSlipPost findOneById(int id) { return betSlipPostRepository.findOneById(id);}
}

