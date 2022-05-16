package com.BettleAPI.service;

import com.BettleAPI.entity.Bettor;

import com.BettleAPI.repository.BettorRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BettorService {
    private final BettorRepository bettorRepository;

    public Bettor save(Bettor bettor) {
        return bettorRepository.save(bettor);
    }

    public void delete(int id) {
        bettorRepository.deleteById(id);
    }

    public List<Bettor> findAll() {
        return bettorRepository.findAll();
    }

    public Bettor findOneById(int id) { return bettorRepository.findOneById(id);}

    public void updateBettor(int id, int balance, int friend_count) { bettorRepository.updateBettor(id, balance, friend_count); }
}

