package com.izzaz.mission2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/game")
    public void addGame(@RequestBody Game game){
        gameService.addGame(game);
    }

    //Read all
    @GetMapping("/game")
    public List<Game> getList(){
        return gameService.getGameList();
    }

    //Read entry
    @GetMapping("/game/{gameId}")
    public Game getGame(@PathVariable("gameId") Integer gameId){
        return gameService.getGame(gameId);
    }

    //update an existing game entry
    @PutMapping("/game/{gameId}")
    public void updateGame(@PathVariable("gameId") Integer gameId, @RequestBody Game game){
        gameService.gameUpdate(gameId,game);
    }

    //Delete an existing game entry
    @DeleteMapping("/game/{gameId}")
    public void deleteGame(@PathVariable("gameId") Integer gameId){
        gameService.deleteGame(gameId);
    }
}
