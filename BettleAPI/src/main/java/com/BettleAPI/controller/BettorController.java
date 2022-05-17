package com.BettleAPI.controller;

import com.BettleAPI.entity.*;

import com.BettleAPI.entity.compositeId.FriendId;
import com.BettleAPI.entity.compositeId.SubscribeId;
import com.BettleAPI.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "bettor")
@RestController
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BettorController {
    private final BettorService bettorService;
    private final BettorHasSlipService bettorHasSlipService;
    private final BetSlipService betSlipService;
    private final FriendService friendService;
    private final SubscribeService subscribeService;
    private final SocialUserService socialUserService;
    private final EditorService editorService;

    @GetMapping("/list")
    public List<Bettor> getBettors() {
        return bettorService.findAll();
    }

    @GetMapping("/show")
    public Bettor getBettorById(@RequestParam("bettor_id") int id) {
        return bettorService.findOneById(id);
    }

    @PutMapping
    public void updateBettor(@RequestParam("bettor_id") int id, @RequestParam("balance") int balance, @RequestParam("friend_count") int friendCount) {
        bettorService.updateBettor(id, balance, friendCount);
    }

    @GetMapping("/bet-slips")
    public List<BetSlip> getBetSlipByBettorId(@RequestParam("editor_id") int id) {
        List<Integer> betSlipIdList = bettorHasSlipService.findBetSlipIdByUserId(id);
        List<BetSlip> betSlipList = new ArrayList<>();

        for (int k: betSlipIdList)
            betSlipList.add(betSlipService.findOneById(k));

        return betSlipList;
    }

    @GetMapping("/friends")
    public List<Bettor> getFriendsByUserId(@RequestParam("bettor_id") int id) {
        List<Integer> bettorIdList =  friendService.findFriendsByUserId(id);
        List<Bettor> bettorList = new ArrayList<>();
        for (int k: bettorIdList)
            bettorList.add(bettorService.findOneById(k));

        return bettorList;
    }

    @GetMapping("subscribed-editors")
    public List<SocialUser> getSubscribedEditorIdsByBettorId(@RequestParam("bettor_id") int id) {
        List<Integer> editorIdList = subscribeService.findSubscribedEditorIdsByBettorId(id);
        List<SocialUser> editorList = new ArrayList<>();

        for (int k: editorIdList)
            editorList.add(socialUserService.findOneById(k));

        return editorList;
    }

    @PostMapping("/add-friend")
    public void saveFriends(@RequestParam("first_bettor_id") int firstBettorId, @RequestParam("second_bettor_id") int secondBettorId) {
        FriendId friendId = new FriendId();
        friendId.setFirstBettorId(firstBettorId);
        friendId.setSecondBettorId(secondBettorId);

        Friend friend = new Friend();
        friend.setId(friendId);
        friendService.save(friend);

        FriendId friendId2 = new FriendId();
        friendId2.setFirstBettorId(secondBettorId);
        friendId2.setSecondBettorId(firstBettorId);

        Friend friend2 = new Friend();
        friend2.setId(friendId2);
        friendService.save(friend2);

        bettorService.updateBettor(firstBettorId, -1, bettorService.findOneById(firstBettorId).getFriendCount() + 1);
        bettorService.updateBettor(secondBettorId, -1, bettorService.findOneById(secondBettorId).getFriendCount() + 1);

    }

    @PostMapping("/remove-friend")
    public void removeFriend(@RequestParam("user_id") int user_id, @RequestParam("friend_id") int friend_id){
        FriendId friendId = new FriendId();
        friendId.setFirstBettorId(user_id);
        friendId.setSecondBettorId(friend_id);
        friendService.delete(friendId);
        friendId.setSecondBettorId(user_id);
        friendId.setFirstBettorId(friend_id);
        friendService.delete(friendId);

        bettorService.updateBettor(user_id, -1, bettorService.findOneById(user_id).getFriendCount() - 1);
        bettorService.updateBettor(friend_id, -1, bettorService.findOneById(friend_id).getFriendCount() - 1);
    }

    @PostMapping("/remove-subscribed-editor")
    public void removeSubscribed(@RequestParam("user_id") int user_id, @RequestParam("editor_id") int editor_id){
        SubscribeId subscribeId = new SubscribeId();
        subscribeId.setBettorId(user_id);
        subscribeId.setEditorId(editor_id);
        subscribeService.delete(subscribeId);
        editorService.updateEditor(editor_id, editorService.findOneById(editor_id).getSubscriberCount() - 1, -1);
    }
}
