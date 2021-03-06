package com.BettleAPI.controller;

import com.BettleAPI.dto.BetDto;
import com.BettleAPI.dto.BetSlipPostDto;
import com.BettleAPI.entity.*;
import com.BettleAPI.entity.compositeId.PostedId;
import com.BettleAPI.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.function.AbstractAnsiTrimEmulationFunction;
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
    private final DisplayService displayService;
    private final BetService betService;
    private final FriendService friendService;
    private final SocialUserService socialUserService;
    private final BetSlipService betSlipService;
    private final GameService gameService;
    private final EditorService editorService;
    private final SubscribeService subscribeService;

    @GetMapping()
    public List<BetSlipPostDto> getBetSlipPostsOfFriends(@RequestParam("user_id") int userId) {
        List<BetSlipPostDto> betSlipPostDtos = new ArrayList<>(); //return list

        List<Integer> friendIdList = friendService.findFriendsByUserId(userId); //get friend id list
        List<Integer> editorIdList = subscribeService.findSubscribedEditorIdsByBettorId(userId);

        for (int k: friendIdList) {
            List<Integer> betSlipPostIdsList = postedService.findAllBetSlipPostsByUserId(k); //get all bet slip posts of a friend

            for (int m: betSlipPostIdsList) {
                BetSlipPostDto betSlipPostDto = new BetSlipPostDto(); //create dto to be added to the return list

                betSlipPostDto.setUsername(userService.findOneById(k).getUsername());

                Posted posted = postedService.findPostedByBetSlipPostIdAndUserId(m,k); //find posted entity by user_id and bet_slip_post_id
                BetSlip betSlip = betSlipService.findOneById(posted.getId().getBetSlipId()); //get bet slip of that specific post

                betSlipPostDto.setBetSlipId(betSlip.getId()); //set bet_slip id

                List<Integer> idListOfBets = displayService.findBetsByBetSlipId(betSlip.getId()); //get bet_id_list of bet_slip

                List<BetDto> bets = new ArrayList<>();
                for(int b: idListOfBets) {
                    BetDto betDto = new BetDto();
                    betDto.setBet(betService.findOneById(b));
                    betDto.setGame(gameService.findOneById(betService.findOneById(b).getGameId()));
                    bets.add(betDto); //add bets to list
                }
                betSlipPostDto.setBets(bets); //set bets as that list

                betSlipPostDto.setText(betSlipPostService.findOneById(m).getPostText());
                betSlipPostDto.setLikeCount(postLikeService.getLikeCountByBetSlipPostId(m));
                betSlipPostDto.setUserId(userId);
                betSlipPostDto.setEditor(false);

                betSlipPostDtos.add(betSlipPostDto);
            }
        }

        for (int k: editorIdList) {
            List<Integer> betSlipPostIdsList = postedService.findAllBetSlipPostsByUserId(k); //get all bet slip posts of a friend

            for (int m: betSlipPostIdsList) {
                BetSlipPostDto betSlipPostDto = new BetSlipPostDto(); //create dto to be added to the return list

                betSlipPostDto.setUsername(userService.findOneById(k).getUsername());

                Posted posted = postedService.findPostedByBetSlipPostIdAndUserId(m,k); //find posted entity by user_id and bet_slip_post_id
                BetSlip betSlip = betSlipService.findOneById(posted.getId().getBetSlipId()); //get bet slip of that specific post

                betSlipPostDto.setBetSlipId(betSlip.getId()); //set bet_slip id

                List<Integer> idListOfBets = displayService.findBetsByBetSlipId(betSlip.getId()); //get bet_id_list of bet_slip

                List<BetDto> bets = new ArrayList<>();
                for(int b: idListOfBets) {
                    BetDto betDto = new BetDto();
                    betDto.setBet(betService.findOneById(b));
                    betDto.setGame(gameService.findOneById(betService.findOneById(b).getGameId()));
                    bets.add(betDto); //add bets to list
                }
                betSlipPostDto.setBets(bets); //set bets as that list

                betSlipPostDto.setText(betSlipPostService.findOneById(m).getPostText());
                betSlipPostDto.setLikeCount(postLikeService.getLikeCountByBetSlipPostId(m));
                betSlipPostDto.setUserId(userId);
                betSlipPostDto.setEditor(true);

                betSlipPostDtos.add(betSlipPostDto);
            }
        }

        return betSlipPostDtos;
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

    @GetMapping("/posted")
    public List<BetSlipPostDto> getUserPosts(@RequestParam("user_id") int id) {
        //editor check
        boolean isEditor = false;
        List<Editor> editors = editorService.findAll();
        for (Editor e: editors)
            if (e.getId() == id)
                isEditor = true;

        List<Integer> betSlips = postedService.findAllBetSlipsByUserId(id);

        List<BetSlipPostDto> dtos = new ArrayList<>();
        for(int k : betSlips){
            List<Integer> betIds = displayService.findBetsByBetSlipId(k);

            List<BetDto> betDtos = new ArrayList<>();
            for(int m: betIds) {
                BetDto betDto = new BetDto();

                betDto.setGame(gameService.findOneById(betService.findOneById(m).getGameId()));

                betDto.setBet(betService.findOneById(m));
                betDtos.add(betDto);
            }
            int betSlipPostId = postedService.findPostFromBetSlipId(k);
            String postText = betSlipPostService.findOneById(betSlipPostId).getPostText();

            BetSlipPostDto dto = new BetSlipPostDto();
            dto.setBets(betDtos);
            dto.setText(postText);
            dto.setBetSlipId(k);
            dto.setLikeCount(postLikeService.getLikeCountByBetSlipPostId(betSlipPostId));

            dto.setUserId(id);
            dto.setUsername(userService.findOneById(id).getUsername());
            dto.setEditor(isEditor);

            dtos.add(dto);
        }
        return dtos;
    }

}
