package com.BettleAPI.controller;

import com.BettleAPI.entity.*;
import com.BettleAPI.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "editor")
@RestController
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class EditorController {
    private final EditorService editorService;
    private final EditorHasSlipService editorHasSlipService;
    private final BetSlipService betSlipService;
    private final SubscribeService subscribeService;
    private final SocialUserService socialUserService;

    @GetMapping("/list")
    public List<Editor> getEditors() {
        return editorService.findAll();
    }

    @GetMapping("/show")
    public Editor getEditorById(@RequestParam("editor_id") int id) {
        return editorService.findOneById(id);
    }

    @PutMapping
    public void updateEditor(@RequestParam("editor_id") int id, @RequestParam("subscriber_count") int subscriberCount, @RequestParam("successful_bet_slip_count") int successfulBetSlipCount) {
        editorService.updateEditor(id, subscriberCount, successfulBetSlipCount);
    }

    @GetMapping("/bet-slips")
    public List<BetSlip> getBetSlipByEditorId(@RequestParam("editor_id") int id) {
        List<Integer> betSlipIdList = editorHasSlipService.findBetSlipIdsByEditorId(id);
        List<BetSlip> betSlipList = new ArrayList<>();

        for (int k: betSlipIdList)
            betSlipList.add(betSlipService.findOneById(k));
        return betSlipList;
    }

    @GetMapping("/subscribers")
    public List<SocialUser> getSubscribedIdsByEditorId(@RequestParam("editor_id") int id) {
        List<Integer> bettorIdList = subscribeService.findSubscribedIdsByEditorId(id);
        List<SocialUser> bettorList = new ArrayList<>();

        for (int k: bettorIdList)
            bettorList.add(socialUserService.findOneById(k));

        return bettorList;
    }
}
