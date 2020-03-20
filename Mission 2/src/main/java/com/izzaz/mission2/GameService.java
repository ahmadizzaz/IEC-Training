package com.izzaz.mission2;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    List<Game> gameList = new ArrayList<>();

    //create
    public void addGame(Game game){
        gameList.add(game);
    }

    //Get game based on id
    public Game getGame(Integer gameId){
        for (Game game : gameList){
            if (game.getId().equals(gameId)){
                return game;
            }
        }
        return null;
    }

    //Get all games
    public List<Game> getGameList(){
        return gameList;
    }

    //Update a game entry using id
    public void gameUpdate(Integer gameId, Game newGame){
        for (Game game : gameList){
            if (game.getId().equals(gameId)){
                gameList.set(gameList.indexOf(game),newGame);
            }
        }
    }

    //Delete game entry
    public void deleteGame(Integer gameId){
        gameList.remove(getGame(gameId));
    }
}

