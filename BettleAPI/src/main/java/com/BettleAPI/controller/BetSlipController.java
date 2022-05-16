package com.BettleAPI.controller;

import com.BettleAPI.entity.Bet;
import com.BettleAPI.entity.BetSlip;
import com.BettleAPI.service.BetService;
import com.BettleAPI.service.BetSlipService;
import com.BettleAPI.service.BettorHasSlipService;
import com.BettleAPI.service.DisplayService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "betslip")
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BetSlipController {
    private final BetSlipService betSlipService;
    private final BetService betService;
    private final DisplayService displayService;

    @GetMapping("/show")
    public BetSlip getBetSlipById(@RequestParam("bet_slip_id") int id) {
        return betSlipService.findOneById(id);
    }

    @DeleteMapping
    public void deleteBetSlip(@PathVariable int id) {
        betSlipService.delete(id);
    }

    @PutMapping
    public void updateBetSlip(@RequestParam("bet_slip_id") int id, @RequestParam("odd") double odd) { //may need to require calculating the new odd
        betSlipService.updateBetSlip(id,odd);
    }

    @GetMapping
    public List<Bet> getBetsByBetSlipId(@RequestParam("bet_slip_id") int id) {
        List<Integer> betIdList = displayService.findBetsByBetSlipId(id);
        List<Bet> betList = new ArrayList<>();
        for(int k: betIdList)
            betList.add(betService.findOneById(k));

        return betList; //not sure
    }

/*
    @PostMapping
    public void saveBetSlip(@RequestParam("odd") double odd) {      //betler ne olarak gelicek
        Game game = new Game();
        game.setDate(date);
        game.setFirstTeamName(firstTeamName);
        game.setSecondTeamName(secondTeamName);

        // add constraints if exists

        gameService.save(game);
        throw new ResponseStatusException(HttpStatus.OK, "Game successfully saved");
    }
*/
}