package com.BettleAPI.controller;

import com.BettleAPI.entity.Admin;
import com.BettleAPI.entity.SocialUser;
import com.BettleAPI.service.AdminService;
import com.BettleAPI.service.BansService;
import com.BettleAPI.service.SocialUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "social-user")
@RestController
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class SocialUserController {
    private final SocialUserService socialUserService;
    private final AdminService adminService;
    private final BansService bansService;

    @GetMapping("/list")
    public List<SocialUser> getSocialUsers() {
        return socialUserService.findAll();
    }

    @GetMapping("/show")
    public SocialUser getSocialUserById(@RequestParam("social_user_id") int id) {
        return socialUserService.findOneById(id);
    }

    @PutMapping
    public void updateSocialUser(@RequestParam("social_user_id") int id, @RequestParam("email") String email,
                                 @RequestParam("first_name") String firstName, @RequestParam("gender") String gender,
                                 @RequestParam("last_name") String lastName, @RequestParam("nationality") String nationality) {
        socialUserService.updateSocialUser(id, email, firstName, gender, lastName, nationality);
    }

    @GetMapping("/banned")
    public Admin getAdminIdByBannedUser(@RequestParam("admin-id") int id){
        return adminService.findOneById(bansService.findAdminIdByBannedUser(id));
    }
}
