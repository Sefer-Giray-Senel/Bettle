package com.BettleAPI.service;

import com.BettleAPI.entity.Bans;

import com.BettleAPI.entity.compositeId.BansId;
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

    public void delete(BansId id) {
        bansRepository.deleteById(id);
    }

    public List<Bans> findAll() {
        return bansRepository.findAll();
    }

    public Bans findOneById(BansId id) { return bansRepository.findOneById(id.getAdminId(), id.getSocialUserId());}

    public Integer findAdminIdByBannedUser(int userId){ return bansRepository.findAdminIdByBannedUser(userId); }
}
