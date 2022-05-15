package com.BettleAPI.service;

import com.BettleAPI.entity.Subscribe;

import com.BettleAPI.repository.SubscribeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;

    public Subscribe save(Subscribe subscribe) {
        return subscribeRepository.save(subscribe);
    }
/*
    public void delete(UUID id) {
        subscribeRepository.deleteById(id);
    }

    public List<Subscribe> findAll() {
        return subscribeRepository.findAll();
    }

    public Subscribe getByID(UUID id) { return subscribeRepository.getById(id);}

    public Long count() {
        return subscribeRepository.count();
    }

 */
}