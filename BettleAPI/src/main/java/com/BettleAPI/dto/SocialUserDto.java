package com.BettleAPI.dto;


import com.BettleAPI.entity.Bet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SocialUserDto {

    private String firstName;
    private String lastName;
    private String nationality;
    private String email;
    private String gender;

    private double balance;
    private int friendCount;

    private int subscriberCount;
    private int successfulBetSlipCount;

    private boolean isEditor;

    private boolean isFriend;
    private boolean isSubscribed;
}