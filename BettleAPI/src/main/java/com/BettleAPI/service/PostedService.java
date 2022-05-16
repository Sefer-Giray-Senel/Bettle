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

}