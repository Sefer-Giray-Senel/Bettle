package com.BettleAPI.controller;

import com.BettleAPI.dto.SocialUserDto;
import com.BettleAPI.entity.*;
import com.BettleAPI.entity.compositeId.SubscribeId;
import com.BettleAPI.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

@RequestMapping(path = "social-user")
@RestController
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class SocialUserController {
    private final SocialUserService socialUserService;
    private final AdminService adminService;
    private final BansService bansService;
    private final EditorService editorService;
    private final BettorService bettorService;
    private final SubscribeService subscribeService;

    @GetMapping("/list")
    public List<SocialUser> getSocialUsers() {
        return socialUserService.findAll();
    }

    @GetMapping("/profile")
    public SocialUserDto getSocialUserById(@RequestParam("social_user_id") int id) {
        SocialUser socialUser = socialUserService.findOneById(id);
        SocialUserDto socialUserDto = new SocialUserDto();

        socialUserDto.setEmail(socialUser.getEmail());
        socialUserDto.setFirstName(socialUser.getFirstName());
        socialUserDto.setGender(socialUser.getGender());
        socialUserDto.setLastName(socialUser.getLastName());
        socialUserDto.setNationality(socialUser.getNationality());
        
        Editor editor = editorService.findOneById(id);
        if (editor != null) {
            socialUserDto.setEditor(true);
            socialUserDto.setBalance(-1);
            socialUserDto.setFriendCount(-1);
            socialUserDto.setSubscriberCount(editor.getSubscriberCount());
            socialUserDto.setSuccessfulBetSlipCount(editor.getSuccessfulBetSlipCount());
        }
        else {
            Bettor bettor = bettorService.findOneById(id);

            socialUserDto.setEditor(false);
            socialUserDto.setBalance(bettor.getBalance());
            socialUserDto.setFriendCount(bettor.getFriendCount());
            socialUserDto.setSubscriberCount(-1);
            socialUserDto.setSuccessfulBetSlipCount(-1);
        }

        return socialUserDto;
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

    @PostMapping
    public void subscribe(@RequestParam("editor_id") int editor_id, @RequestParam("bettor_id") int bettor_id){
        Subscribe newSubscribe = new Subscribe();
        SubscribeId subscribeId = new SubscribeId();

        subscribeId.setBettorId(bettor_id);
        subscribeId.setEditorId(editor_id);
        newSubscribe.setId(subscribeId);
        subscribeService.save(newSubscribe);
        editorService.findOneById(editor_id).setSubscriberCount(editorService.findOneById(editor_id).getSubscriberCount() + 1);
    }
}
