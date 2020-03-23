package com.izzaz.mission4.controller;

import com.izzaz.mission4.service.GameService;
import com.izzaz.mission4.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/game")
    public void addGame(@RequestBody Game game) throws SQLException {
        gameService.addGame(game);
    }

    //Read all
    @GetMapping("/game")
    public List<Game> getList() throws SQLException {
        return gameService.getGameList();
    }

    //Read entry
    @GetMapping("/game/{gameId}")
    public Game getGame(@PathVariable("gameId") Integer gameId) throws SQLException {
        return gameService.getGame(gameId);
    }

    //update an existing game entry
    @PutMapping("/game/{gameId}")
    public void updateGame(@PathVariable("gameId") Integer gameId, @RequestBody Game game) throws SQLException {
        gameService.gameUpdate(gameId,game);
    }

    //Delete an existing game entry
    @DeleteMapping("/game/{gameId}")
    public void deleteGame(@PathVariable("gameId") Integer gameId) throws SQLException {
        gameService.deleteGame(gameId);
    }
}
