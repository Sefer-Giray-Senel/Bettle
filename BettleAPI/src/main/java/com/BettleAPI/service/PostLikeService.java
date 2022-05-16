package com.BettleAPI.service;

import com.BettleAPI.entity.PostLike;

import com.BettleAPI.entity.compositeId.PostLikeId;
import com.BettleAPI.repository.PostLikeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class PostLikeService {
    private final PostLikeRepository postLikeRepository;

    public PostLike save(PostLike postLike) {
        return postLikeRepository.save(postLike);
    }

    public void delete(PostLikeId id) {
        postLikeRepository.deleteById(id);
    }

    public List<PostLike> findAll() {
        return postLikeRepository.findAll();
    }

    public PostLike findOneById(PostLikeId id) { return postLikeRepository.findOneById(id.getBetSlipPostId(),id.getUserId());}

    //public List<Integer> findLikedPostsByUserId(int userId){ return postLikeRepository.findLikedPostsByUserId(userId); }

    public List<Integer> findUserIdsByLikedPostId(int postId){ return postLikeRepository.findUserIdsByLikedPostId(postId); }
}