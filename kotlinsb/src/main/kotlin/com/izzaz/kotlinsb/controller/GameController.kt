package com.izzaz.kotlinsb.controller

import com.izzaz.kotlinsb.entity.Game
import com.izzaz.kotlinsb.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.sql.SQLException

@RestController
class GameController(@Autowired var gameService: GameService) {

    @PostMapping("/game")
    @Throws(SQLException::class)
    fun addGame(@RequestBody game : Game){
        return gameService.addGame(game)
    }

    @GetMapping("/game")
    @Throws(SQLException::class)
    fun getGameList() : List<Game>{
        return gameService.getGameList()
    }

    @GetMapping("/game/{gameId}")
    @Throws(SQLException::class)
    fun getGame(@PathVariable("gameId") gameId: Int) : Game?{
        return gameService.getGame(gameId)
    }

    @PutMapping("/game/{gameId}")
    @Throws(SQLException::class)
    fun updateGame(@PathVariable("gameId") gameId: Int, @RequestBody game : Game){
        gameService.gameUpdate(gameId,game)
    }

    @DeleteMapping("game/{gameId}")
    @Throws(SQLException::class)
    fun deleteGame(@PathVariable("gameId") gameId: Int){
        gameService.deleteGame(gameId)
    }
    @DeleteMapping("/game")
    fun deleteAllGame(){
        gameService.deleteAllGame()
    }

}