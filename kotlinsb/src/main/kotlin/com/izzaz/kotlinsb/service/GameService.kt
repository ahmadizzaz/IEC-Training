package com.izzaz.kotlinsb.service

import com.izzaz.kotlinsb.entity.Game
import com.izzaz.kotlinsb.repository.GameRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameService(@Autowired var gameRepository : GameRepo) {

    fun addGame(game : Game) {gameRepository.addGame(game)}

    fun getGame(gameId : Int) : Game? {return gameRepository.getGame(gameId)}

    fun getGameList() : List<Game> {return gameRepository.getGameList()}

    fun gameUpdate(gameId: Int,newGame: Game)  {gameRepository.gameUpdate(gameId,newGame)}

    fun deleteGame(gameId: Int)  {gameRepository.deleteGame(gameId)}

    fun deleteAllGame()  {gameRepository.deleteAllGame()}

}