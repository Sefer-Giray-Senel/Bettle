package com.BettleAPI.service;

import com.BettleAPI.entity.SlipComment;

import com.BettleAPI.entity.compositeId.PostLikeId;
import com.BettleAPI.repository.SlipCommentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class SlipCommentService {
    private final SlipCommentRepository slipCommentRepository;

    public SlipComment save(SlipComment slipComment) {
        return slipCommentRepository.save(slipComment);
    }

    public void delete(PostLikeId id) {
        slipCommentRepository.deleteById(id);
    }

    public List<SlipComment> findAll() {
        return slipCommentRepository.findAll();
    }

    public SlipComment findOneById(PostLikeId id) { return slipCommentRepository.findOneById(id.getBetSlipPostId(), id.getUserId());}

    public List<SlipComment> findCommentsBySlipPostId(int betSlipPostId){ return slipCommentRepository.findCommentsBySlipPostId(betSlipPostId); }
}
