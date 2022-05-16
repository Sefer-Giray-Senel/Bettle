package com.BettleAPI.service;

import com.BettleAPI.entity.Bet;

import com.BettleAPI.repository.BetRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class BetService {
    private final BetRepository betRepository;

    public Bet save(Bet bet) {
        return betRepository.save(bet);
    }

    public void delete(int id) {
        betRepository.deleteById(id);
    }

    public List<Bet> findAll() {
        return betRepository.findAll();
    }

    public Bet findOneById(int id) { return betRepository.findOneById(id);}

    public List<Bet> findBetsForGame(int gameId) {
        return betRepository.findBetsForGame(gameId);
    }

    public void updateBet(int id, double odd) { betRepository.updateBet(id,odd); }
}

