package com.BettleAPI.service;

import com.BettleAPI.entity.Friend;

import com.BettleAPI.entity.compositeId.FriendId;
import com.BettleAPI.repository.FriendRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class FriendService {
    private final FriendRepository friendRepository;

    public Friend save(Friend friend) {
        return friendRepository.save(friend);
    }

    public void delete(FriendId id) {
        friendRepository.deleteById(id);
    }

    public List<Friend> findAll() {
        return friendRepository.findAll();
    }

    public Friend findOneById(FriendId id) { return friendRepository.findOneById(id.getFirstBettorId(), id.getSecondBettorId());}
/*
    public Long count() {
        return friendRepository.count();
    }
    */
}



