package com.izzaz.mission7.service;


import com.izzaz.mission7.exception.EmptyParamException;
import com.izzaz.mission7.exception.GameNotFoundException;
import com.izzaz.mission7.exception.IdParamException;
import com.izzaz.mission7.exception.NoDataFoundException;
import com.izzaz.mission7.repository.GameRepository;
import com.izzaz.mission7.entity.Game;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j2
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
                log.debug(ex);
                throw new IdParamException();
            }
        }

        public Game getGame(Integer gameId){
            try{
                return gameRepo.getGame(gameId);
            }catch(Exception ex){
                log.debug(ex);
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

