package com.BettleAPI.service;

import com.BettleAPI.entity.PostLike;
import com.BettleAPI.entity.Posted;
import com.BettleAPI.entity.compositeId.PostLikeId;
import com.BettleAPI.entity.compositeId.PostedId;
import com.BettleAPI.repository.PostLikeRepository;
import com.BettleAPI.repository.PostedRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class PostedService {
    private final PostedRepository postedRepository;

    public Posted save(Posted posted) {
        return postedRepository.save(posted);
    }

    public void delete(PostedId id) {
        postedRepository.deleteById(id);
    }

    public List<Posted> findAll() {
        return postedRepository.findAll();
    }

    public Posted findOneById(PostedId id) { return postedRepository.findOneById(id.getBetSlipPostId(), id.getBetSlipId(), id.getUserId());}

    public Integer findPostFromBetSlipId(int betSlipId){ return postedRepository.findPostFromBetSlipId(betSlipId); }

    public List<Integer> findAllBetSlipPostsByUserId(int betSlipPostId){ return postedRepository.findAllBetSlipPostsByUserId(betSlipPostId); }

    public List<Integer> findAllBetSlipsByUserId(int givenUserId) { return postedRepository.findAllBetSlipsByUserId(givenUserId); }

    public Posted findPostedByBetSlipPostIdAndUserId(int givenBetSlipPostId, int givenUserId){
        return postedRepository.findPostedByBetSlipPostIdAndUserId(givenBetSlipPostId, givenUserId);
    }
}