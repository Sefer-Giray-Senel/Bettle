package com.BettleAPI.service;

import com.BettleAPI.entity.Display;

import com.BettleAPI.entity.compositeId.DisplayId;
import com.BettleAPI.repository.DisplayRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class DisplayService {
    private final DisplayRepository displayRepository;

    public Display save(Display display) {
        return displayRepository.save(display);
    }

    public void delete(DisplayId id) {
        displayRepository.deleteById(id);
    }

    public List<Display> findAll() {
        return displayRepository.findAll();
    }

    public Display findOneById(DisplayId id) { return displayRepository.findOneById(id.getBetId(), id.getBetSlipId());}
/*
    public Long count() {
        return displayRepository.count();
    }
*/
}
