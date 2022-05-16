package com.BettleAPI.controller;

import com.BettleAPI.entity.BetSlipPost;
import com.BettleAPI.entity.SlipComment;
import com.BettleAPI.entity.User;
import com.BettleAPI.service.BetSlipPostService;
import com.BettleAPI.service.PostLikeService;
import com.BettleAPI.service.SlipCommentService;
import com.BettleAPI.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "feed")
@RestController
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BetSlipPostController {
    private final BetSlipPostService betSlipPostService;
    private final PostLikeService postLikeService;
    private final UserService userService;
    private final SlipCommentService slipCommentService;

    @GetMapping()
    public List<BetSlipPost> getBetSlipPosts() {
        return betSlipPostService.findAll();
    }

    @GetMapping("/show")
    public BetSlipPost getBetSlipPostById(@RequestParam("bet_slip_post_id") int id) {
        return betSlipPostService.findOneById(id);
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
