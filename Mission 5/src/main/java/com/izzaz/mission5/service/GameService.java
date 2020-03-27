package com.izzaz.mission5.service;


import com.izzaz.mission5.exception.EmptyParamException;
import com.izzaz.mission5.exception.GameNotFoundException;
import com.izzaz.mission5.exception.IdParamException;
import com.izzaz.mission5.exception.NoDataFoundException;
import com.izzaz.mission5.repository.GameRepository;
import com.izzaz.mission5.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {


    @Autowired
    private GameRepository gameRepo;

        public void addGame(Game game){
            if ((game.getName().isEmpty())||game.getPlatform().isEmpty()){
                throw new EmptyParamException();
            }
            try{
                gameRepo.addGame(game);
            }catch(Exception ex){
                throw new IdParamException();
            }
        }

        public Game getGame(Integer gameId){
            try{
                return gameRepo.getGame(gameId);
            }catch(Exception ex){
                throw new GameNotFoundException(gameId);
            }
        }


        public List<Game> getGameList() {
            var gameList = (List<Game>)gameRepo.getGameList();
            if (gameList.isEmpty()){
                throw new NoDataFoundException();
            }
            return gameList;
        }


        public void gameUpdate(Integer gameId, Game newGame) {

           gameRepo.gameUpdate(gameId,newGame);
        }


        public void deleteGame(Integer gameId) {
                gameRepo.deleteGame(gameId);
        }

     public void deleteAllGame() {
        gameRepo.deleteAllGame();
    }


}

