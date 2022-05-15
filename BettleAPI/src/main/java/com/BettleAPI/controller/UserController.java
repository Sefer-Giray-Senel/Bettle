package com.BettleAPI.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.BettleAPI.config.JwtAuthorizationFilter;
import com.BettleAPI.entity.Admin;
import com.BettleAPI.entity.User;
import com.BettleAPI.service.AdminService;
import com.BettleAPI.service.UserService;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    private final AdminService adminService;

    @PostMapping("/login")
    public User login(@RequestParam("username") String username, @RequestParam("password") String pwd) {

        String token = getJWTToken(username);
        User user = new User();

        user.setUsername(username);
        user.setToken(token);
        return user;
    }

    @PostMapping("/users")
    public List<Admin> userList() {
        return adminService.findAll();
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
