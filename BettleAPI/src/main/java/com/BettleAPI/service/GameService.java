package com.BettleAPI.service;

import com.BettleAPI.entity.Game;

import com.BettleAPI.repository.GameRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class GameService {
    private final GameRepository gameRepository;

    public Game save(Game match) {
        return gameRepository.save(match);
    }

    public void delete(int id) {
        gameRepository.deleteById(id);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findOneById(int id) { return gameRepository.findOneById(id);}

    public void updateGame(int id, Date date) { gameRepository.updateGame(id, date); }
}