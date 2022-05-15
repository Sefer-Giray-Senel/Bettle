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
/*
    public void delete(UUID id) {
        bettorRepository.deleteById(id);
    }

    public List<Bettor> findAll() {
        return bettorRepository.findAll();
    }

    public Bettor getByID(UUID id) { return bettorRepository.getById(id);}

    public Long count() {
        return bettorRepository.count();
    }
    */
}

