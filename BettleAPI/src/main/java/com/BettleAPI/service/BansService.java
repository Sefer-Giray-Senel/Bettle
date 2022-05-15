package com.BettleAPI.service;

import com.BettleAPI.entity.Bans;

import com.BettleAPI.repository.BansRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BansService {
    private final BansRepository bansRepository;

    public Bans save(Bans bans) {
        return bansRepository.save(bans);
    }

    public void delete(UUID id) {
        bansRepository.deleteById(id);
    }

    public List<Bans> findAll() {
        return bansRepository.findAll();
    }

    public Bans getByID(UUID id) { return bansRepository.getById(id);}

    public Long count() {
        return bansRepository.count();
    }
}

