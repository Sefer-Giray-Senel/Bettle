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
public class BetSlipPostDto {
    private List<BetDto> bets;
    private String text;
    private int betSlipId;
    private int likeCount;

    private String username;
    private int userId;

    private boolean isEditor;
}
