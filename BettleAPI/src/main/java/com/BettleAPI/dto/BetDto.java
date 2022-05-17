package com.BettleAPI.dto;

import com.BettleAPI.entity.Bet;
import com.BettleAPI.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BetDto {
    private Bet bet;
    Game game;
}
