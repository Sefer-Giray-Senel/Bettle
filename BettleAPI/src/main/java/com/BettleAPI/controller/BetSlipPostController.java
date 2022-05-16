package com.BettleAPI.controller;

import com.BettleAPI.entity.BetSlipPost;
import com.BettleAPI.entity.Posted;
import com.BettleAPI.entity.SlipComment;
import com.BettleAPI.entity.User;
import com.BettleAPI.entity.compositeId.PostedId;
import com.BettleAPI.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping(path = "feed")
@RestController
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BetSlipPostController {
    private final BetSlipPostService betSlipPostService;
    private final PostLikeService postLikeService;
    private final UserService userService;
    private final SlipCommentService slipCommentService;
    private final PostedService postedService;

    @GetMapping()
    public List<BetSlipPost> getBetSlipPosts() {
        return betSlipPostService.findAll();
    }

    @GetMapping("/show")
    public BetSlipPost getBetSlipPostById(@RequestParam("bet_slip_post_id") int id) {
        return betSlipPostService.findOneById(id);
    }

    @PostMapping("/share-bet-slip")
    public BetSlipPost saveBetSlipPost(@RequestParam("bet_slip_id") int betSlipId, @RequestParam("user_id") int userId, @RequestParam("post_text") String postText) {
        Random rd = new Random();
        int upperbound = Integer.MAX_VALUE;
        int int_random = rd.nextInt(upperbound);

        BetSlipPost betSlipPost = new BetSlipPost();
        betSlipPost.setId(int_random);
        betSlipPost.setPostText(postText);
        betSlipPostService.save(betSlipPost);

        PostedId postedId = new PostedId();
        postedId.setBetSlipPostId(int_random);
        postedId.setBetSlipId(betSlipId);
        postedId.setUserId(userId);
        Posted posted = new Posted();
        posted.setId(postedId);
        postedService.save(posted);

        return betSlipPost;
    }

    @DeleteMapping
    public void deleteBetSlipPost(@RequestParam("bet_slip_post_id") int id) {
        betSlipPostService.delete(id);
    }

    @GetMapping("/post-liked-by")
    public List<User> findUserIdsByLikedPostId(@RequestParam("post_id") int id) {
        List<Integer> userIdList =  postLikeService.findUserIdsByLikedPostId(id);
        List<User> userList = new ArrayList<>();

        for (int k: userIdList)
            userList.add(userService.findOneById(k));

        return userList;
    }

    @GetMapping("/comments")
    public List<SlipComment> findCommentsBySlipPostId(@RequestParam("post_id") int id) {
        return slipCommentService.findCommentsBySlipPostId(id);
    }


}
