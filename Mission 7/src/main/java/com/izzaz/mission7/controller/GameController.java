package com.izzaz.mission7.controller;

import com.izzaz.mission7.service.GameService;
import com.izzaz.mission7.entity.Game;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Log4j2
@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/")
    public String index(){
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
        return "Logs loaded, check logs for more info.";
    }
    @PostMapping("/game")
    public void addGame(@RequestHeader("userId") Integer userId, @RequestBody Game game) throws SQLException {
        log.debug("User "+userId+" accessed addGame");
        gameService.addGame(game);
    }

    //Read all
    @GetMapping("/game")
    public List<Game> getList(@RequestHeader("userId") Integer userId) throws SQLException {
        log.warn("User "+userId+" is accessing Game List data");
        return gameService.getGameList();
    }

    //Read entry
    @GetMapping("/game/{gameId}")
    public Game getGame(@RequestHeader("userId") Integer userId,@PathVariable("gameId") Integer gameId) throws SQLException {
        log.warn("User "+userId+" is accessing a Game data");
        return gameService.getGame(gameId);
    }

    //update an existing game entry
    @PutMapping("/game/{gameId}")
    public void updateGame(@RequestHeader("userId") Integer userId,@PathVariable("gameId") Integer gameId, @RequestBody Game game) throws SQLException {
        log.debug("User "+userId+" accessed updateGame");
        gameService.gameUpdate(gameId,game);
    }

    //Delete an existing game entry
    @DeleteMapping("/game/{gameId}")
    public void deleteGame(@RequestHeader("userId") Integer userId,@PathVariable("gameId") Integer gameId) throws SQLException {
        log.debug("User "+userId+" accessed deleteGame");
        gameService.deleteGame(gameId);
    }
    @DeleteMapping("/game")
    public void deleteGame(@RequestHeader("userId") Integer userId) throws SQLException {
        log.debug("User "+userId+" accessed deleteGame");
        gameService.deleteAllGame();
    }
}
