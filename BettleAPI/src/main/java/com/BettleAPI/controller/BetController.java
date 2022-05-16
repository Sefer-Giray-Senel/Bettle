package com.BettleAPI.controller;

import com.BettleAPI.entity.Bet;
import com.BettleAPI.service.BetService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "bets")
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BetController {
    private final BetService betService;

    @GetMapping
    public List<Bet> betListByGame(@RequestParam("game_id") int gameId) {
        return betService.findBetsForGame(gameId);
    }

    @DeleteMapping
    public void deleteBet(@PathVariable int id) {
        betService.delete(id);
    }
    
}
