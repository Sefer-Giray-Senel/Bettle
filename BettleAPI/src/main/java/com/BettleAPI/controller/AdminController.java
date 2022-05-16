package com.BettleAPI.controller;

import com.BettleAPI.entity.Admin;
import com.BettleAPI.entity.Bet;
import com.BettleAPI.service.AdminService;
import com.BettleAPI.service.BansService;
import com.BettleAPI.service.BetService;
import com.BettleAPI.service.EditService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "admin")
@RestController
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class AdminController {
    private final AdminService adminService;
    private final EditService editService;
    private final BetService betService;

    @GetMapping("/list")
    public List<Admin> getAdmins() {
        return adminService.findAll();
    }

    @GetMapping("/show")
    public Admin getAdminById(@RequestParam("admin_id") int id) {
        return adminService.findOneById(id);
    }

    @PutMapping
    public void updateAdmin(@RequestParam("admin_id") int id, @RequestParam("phone_no") String phoneNo) {
        adminService.updateAdmin(id, phoneNo);
    }

    @GetMapping("/edited-bets")
    public List<Bet> getBetsEditedByAdminId(@RequestParam("admin-id") int id) {
        List<Integer> betIdList = editService.findBetIdByUserId(id);
        List<Bet> betList = new ArrayList<>();
        for (int k: betIdList)
            betList.add(betService.findOneById(k));

        return betList; //not sure
    }
}
