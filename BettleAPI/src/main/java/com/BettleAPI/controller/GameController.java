package com.BettleAPI.controller;

import com.BettleAPI.entity.Game;
import com.BettleAPI.entity.GameComment;
import com.BettleAPI.service.GameCommentService;
import com.BettleAPI.service.GameService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "match")
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class GameController {
    private final GameService gameService;
    private final GameCommentService gameCommentService;

    @GetMapping("/list")
    public List<Game> getGames() {
        return gameService.findAll();
    }

    @GetMapping("/show")
    public Game getGameById(@RequestParam("game_id") int id) {
        return gameService.findOneById(id);
    }

    @DeleteMapping
    public void deleteGame(@PathVariable int id) {
        gameService.delete(id);
    }

    @PostMapping
    public void saveGame(@RequestParam("first_team_name") String firstTeamName, @RequestParam("second_team_name") String secondTeamName, @RequestParam("date") Date date) {
        Game game = new Game();
        game.setDate(date);
        game.setFirstTeamName(firstTeamName);
        game.setSecondTeamName(secondTeamName);

        // add constraints if exists

        gameService.save(game);
        throw new ResponseStatusException(HttpStatus.OK, "Game successfully saved");
    }

    @PutMapping
    public void updateGame(@RequestParam("game_id") int id, @RequestParam("date") Date date) {
        gameService.updateGame(id, date);
    }

    @GetMapping("/comments")
    public List<GameComment> getGameCommentsByGameId(@RequestParam("game_id") int id) {
        return gameCommentService.findCommentsByGameId(id);
    }

}
