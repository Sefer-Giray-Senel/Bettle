package com.BettleAPI.controller;

import com.BettleAPI.service.BetService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "bets")
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BetController {
    private final BetService betService;



}
