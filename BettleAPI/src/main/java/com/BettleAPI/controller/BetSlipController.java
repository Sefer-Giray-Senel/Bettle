package com.BettleAPI.controller;

import com.BettleAPI.dto.BetSlipDto;
import com.BettleAPI.entity.*;
import com.BettleAPI.entity.compositeId.DisplayId;
import com.BettleAPI.entity.compositeId.HasSlipId;
import com.BettleAPI.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.NoResultException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "bet-slip")
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BetSlipController {
    private final BetSlipService betSlipService;
    private final BetService betService;
    private final DisplayService displayService;
    private final EditorService editorService;
    private final BettorService bettorService;
    private final EditorHasSlipService editorHasSlipService;
    private final BettorHasSlipService bettorHasSlipService;

    @GetMapping("/show")
    public BetSlip getBetSlipById(@RequestParam("bet_slip_id") int id) {
        return betSlipService.findOneById(id);
    }

    @DeleteMapping
    public void deleteBetSlip(@PathVariable int id) {
        betSlipService.delete(id);
    }

    @PutMapping
    public void updateBetSlip(@RequestParam("bets") List<Bet> betList, @RequestParam("bet_slip_id") int id) {

        List<Display> displayList = displayService.findAll();
        for  (Display d: displayList) {
            if (d.getId().getBetSlipId() == id) {
                displayService.delete(d.getId());
            }
        }   //delete existing displays

        BetSlip betSlip = betSlipService.findOneById(id); //find betslip

        double odd = 1;

        for (Bet k: betList) { //create display objects for the updated betslip
            odd *= k.getOdd();

            DisplayId displayId = new DisplayId();
            displayId.setBetSlipId(betSlip.getId());
            displayId.setBetId(k.getId());

            Display display = new Display();
            display.setId(displayId);
            display.setHasOdd(k.getOdd());

            displayService.save(display);
        }

        //Add has slip logic here too

        betSlipService.updateBetSlip(id, odd);
    }

    @GetMapping
    public List<Bet> getBetsByBetSlipId(@RequestParam("bet_slip_id") int id) {
        List<Integer> betIdList = displayService.findBetsByBetSlipId(id);
        List<Bet> betList = new ArrayList<>();
        for(int k: betIdList)
            betList.add(betService.findOneById(k));

        return betList; //not sure
    }


    @PostMapping
    public void saveBetSlip(@RequestParam("bets") List<Integer> betIdList, @RequestParam("user_id") int userId) { //is it List<Bet> or List<Integer>
        BetSlip betSlip = new BetSlip();

        List<Bet> betList = new ArrayList<>();
        for(int k: betIdList)
            betList.add(betService.findOneById(k));

        // add constraints if exists

        double odd = 1;

        Random rd = new Random();
        int upperbound = Integer.MAX_VALUE;
        int int_random = rd.nextInt(upperbound);
        betSlip.setId(int_random);

        for (Bet k: betList) {
            odd *= k.getOdd();

            DisplayId displayId = new DisplayId();
            displayId.setBetSlipId(betSlip.getId());
            displayId.setBetId(k.getId());

            Display display = new Display();
            display.setId(displayId);
            display.setHasOdd(k.getOdd());

            displayService.save(display);
        }

        betSlip.setOdd(odd);
        betSlipService.save(betSlip);

        System.out.println(userId);
        Editor editor = editorService.findOneById(userId);
        if(editor != null) {
            HasSlipId editorHasSlipId = new HasSlipId();
            editorHasSlipId.setBetSlipId(betSlip.getId());
            editorHasSlipId.setUserId(userId);

            EditorHasSlip editorHasSlip = new EditorHasSlip();
            editorHasSlip.setId(editorHasSlipId);

            editorHasSlipService.save(editorHasSlip);
        }
        else{
            Bettor bettor = bettorService.findOneById(userId);

            HasSlipId bettorHasSlipId = new HasSlipId();
            bettorHasSlipId.setBetSlipId(betSlip.getId());
            bettorHasSlipId.setUserId(userId);

            BettorHasSlip bettorHasSlip = new BettorHasSlip();
            bettorHasSlip.setId(bettorHasSlipId);

            bettorHasSlipService.save(bettorHasSlip);
        }
        throw new ResponseStatusException(HttpStatus.OK, "Bet Slip was successfully saved");
    }

    @GetMapping("/blabla")
    public List<BetSlipDto> getBetsByUserId(@RequestParam("user_id") int userId) {
        List<Integer> betSlipIdList = bettorHasSlipService.findBetSlipIdByUserId(userId);
        List<BetSlipDto> betSlipDtoList = new ArrayList<>();

        for (int k: betSlipIdList) {
            BetSlipDto betSlipDto = new BetSlipDto();

            List<Integer> betIdList= displayService.findBetsByBetSlipId(k);
            List<Bet> betList = new ArrayList<>();
            for (int m: betIdList)
                betList.add(betService.findOneById(m));

            betSlipDto.setBetList(betList);
            betSlipDto.setBetSlipId(k);
            betSlipDtoList.add(betSlipDto);
        }

        return betSlipDtoList;
    }
}