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
public class BetSlipDto {
    List<Bet> betList;
    int betSlipId;
}
