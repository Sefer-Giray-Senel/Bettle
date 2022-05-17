package com.BettleAPI.controller;

import java.util.*;
import java.util.stream.Collectors;

import com.BettleAPI.dto.SocialUserDto;
import com.BettleAPI.dto.UserDto;
import com.BettleAPI.entity.Bettor;
import com.BettleAPI.entity.Editor;
import com.BettleAPI.entity.SocialUser;
import com.BettleAPI.entity.User;
import com.BettleAPI.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    private final UserService userService;
    private final EditorService editorService;
    private final BettorService bettorService;
    private final SocialUserService socialUserService;
    private final SubscribeService subscribeService;
    private final FriendService friendService;

    @PostMapping("/login")
    public UserDto login(@RequestParam("username") String username, @RequestParam("password") String pwd) {

        String token = getJWTToken(username);
        User user = userService.findUserByUsername(username);
        UserDto userDto = new UserDto();
        if (user != null) {
            if(pwd.equals(user.getPassword())) {
                userDto.setId(user.getId());
                userDto.setToken(token);
                return userDto;
            }
            else {
                throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Login failed: Password is wrong");
            }
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Login failed: User does not exist");
    }

    @PostMapping("/register")
    public void register(@RequestParam("username") String username, @RequestParam("password") String pwd,
                         @RequestParam("role") String role, @RequestParam("firstname") String firstname,
                         @RequestParam("lastname") String lastname, @RequestParam("email") String email,
                         @RequestParam("gender") String gender, @RequestParam("nationality") String nationality) {

        Random rd = new Random();
        int upperbound = Integer.MAX_VALUE;
        int int_random = rd.nextInt(upperbound);

        if ( username.equals("") || pwd.equals(""))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty username is not valid");


        User existingUser = userService.findUserByUsername(username);
        if (existingUser != null)
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Username is taken");

        User user = new User();

        user.setId(int_random);
        user.setUsername(username);
        user.setPassword(pwd);

        userService.save(user);

        SocialUser newSocialUser = new SocialUser();
        newSocialUser.setId(user.getId());
        newSocialUser.setBanned(false);
        newSocialUser.setEmail(email);
        newSocialUser.setGender(gender);
        newSocialUser.setFirstName(firstname);
        newSocialUser.setLastName(lastname);
        newSocialUser.setNationality(nationality);
        socialUserService.save(newSocialUser);

        if(role.equals("editor")) {
            Editor newEditor = new Editor();
            newEditor.setSubscriberCount(0);
            newEditor.setSuccessfulBetSlipCount(0);
            newEditor.setId(user.getId());

            editorService.save(newEditor);
        }
        else{
            Bettor newBettor = new Bettor();
            newBettor.setBalance(0);
            newBettor.setFriendCount(0);
            newBettor.setId(user.getId());

            bettorService.save(newBettor);
        }
        throw new ResponseStatusException(HttpStatus.OK, "Successfully registered");
    }

    @GetMapping("/users")
    public List<SocialUserDto> userList(@RequestParam("user_id") int id) {
        List<SocialUser> socialUsers = socialUserService.findAll();
        List<SocialUserDto> socialUserDtos = new ArrayList<>();

        for (SocialUser socialUser: socialUsers) {
            SocialUserDto socialUserDto = new SocialUserDto();

            if (id == socialUser.getId())
                continue;

            socialUserDto.setId(socialUser.getId());
            socialUserDto.setUsername(userService.findOneById(socialUser.getId()).getUsername());

            socialUserDto.setEmail(socialUser.getEmail());
            socialUserDto.setFirstName(socialUser.getFirstName());
            socialUserDto.setGender(socialUser.getGender());
            socialUserDto.setLastName(socialUser.getLastName());
            socialUserDto.setNationality(socialUser.getNationality());

            Editor editor = editorService.findOneById(socialUser.getId());
            if (editor != null) {
                socialUserDto.setEditor(true);
                socialUserDto.setBalance(-1);
                socialUserDto.setFriendCount(-1);
                socialUserDto.setSubscriberCount(editor.getSubscriberCount());
                socialUserDto.setSuccessfulBetSlipCount(editor.getSuccessfulBetSlipCount());

                socialUserDto.setFriend(false); //doesn't matter

                List<Integer> subscribedIds = subscribeService.findSubscribedIdsByEditorId(socialUser.getId());
                boolean subscribed = false;
                for (int k: subscribedIds)
                    if (k == id)
                        subscribed = true;

                socialUserDto.setSubscribed(subscribed);
            }
            else {
                Bettor bettor = bettorService.findOneById(socialUser.getId());

                socialUserDto.setEditor(false);
                socialUserDto.setBalance(bettor.getBalance());
                socialUserDto.setFriendCount(bettor.getFriendCount());
                socialUserDto.setSubscriberCount(-1);
                socialUserDto.setSuccessfulBetSlipCount(-1);

                socialUserDto.setSubscribed(false); //doesn't matter
                List<Integer> friendIds = friendService.findFriendsByUserId(socialUser.getId());
                boolean isFriend = false;
                for (int k: friendIds)
                    if (k == id)
                        isFriend = true;
                socialUserDto.setFriend(isFriend);
            }
            socialUserDtos.add(socialUserDto);
        }
        return socialUserDtos;
    }

    @PutMapping
    public void updateUser(@RequestParam("user_id") int id, @RequestParam("username") String username, @RequestParam("password") String password) {
        userService.updateUser(id, username, password);
    }

   /*
   @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }
   */


    private String getJWTToken(String username) {
        String secretKey = "4jJYJXkzUQFTp5ioE1Mq5glhxr15fomjSlCGmzU2snAMvVSdC8CsQPjE1QzvVtaf1X2HwKfdEwt2640K7WIvgCx3lIU8eAaNMCZp7o7BYTMKh8";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("usman")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60000000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey).compact();

        return "Bearer " + token;
    }
}
