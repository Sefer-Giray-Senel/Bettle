package com.BettleAPI.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import com.BettleAPI.dto.UserDto;
import com.BettleAPI.entity.User;
import com.BettleAPI.service.UserService;
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
    public void register(@RequestParam("username") String username, @RequestParam("password") String pwd) {
        Random rd = new Random();
        int upperbound = Integer.MAX_VALUE;
        int int_random = rd.nextInt(upperbound);

        if ( username.equals("") || pwd.equals(""))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty username is not valid");


        User existingUser = userService.findUserByUsername(username);
        if (existingUser != null)
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Actor Not Found");

        User user = new User();

        user.setId(int_random);
        user.setUsername(username);
        user.setPassword(pwd);

        userService.save(user);
        throw new ResponseStatusException(HttpStatus.OK, "Successfully registered");
    }

    @GetMapping("/users")
    public List<User> userList() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }


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
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey).compact();

        return "Bearer " + token;
    }
}
