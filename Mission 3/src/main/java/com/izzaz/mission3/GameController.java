package com.izzaz.mission3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameJDBC gameJdbc;

    @PostMapping("/game")
    public void addGame(@RequestBody Game game) throws SQLException {
        gameJdbc.addGame(game);
    }

    //Read all
    @GetMapping("/game")
    public List<Game> getList() throws SQLException {
        return gameJdbc.getGameList();
    }

    //Read entry
    @GetMapping("/game/{gameId}")
    public Game getGame(@PathVariable("gameId") Integer gameId) throws SQLException {
        return gameJdbc.getGame(gameId);
    }

    //update an existing game entry
    @PutMapping("/game/{gameId}")
    public void updateGame(@PathVariable("gameId") Integer gameId, @RequestBody Game game) throws SQLException {
        gameJdbc.gameUpdate(gameId,game);
    }

    //Delete an existing game entry
    @DeleteMapping("/game/{gameId}")
    public void deleteGame(@PathVariable("gameId") Integer gameId) throws SQLException {
        gameJdbc.deleteGame(gameId);
    }
}
