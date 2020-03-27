package com.izzaz.mission5.repository;


import com.izzaz.mission5.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameRepo implements GameRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //create
    @Override
    public int addGame(Game game) {
        return jdbcTemplate.update("INSERT INTO gametable VALUES(?,?,?)",game.getId(),game.getName(),game.getPlatform());
    }

    //Get game based on id
    @Override
    public Game getGame(Integer gameId) {
        try{
            return  jdbcTemplate.queryForObject(
                    "SELECT id,name,platform FROM gametable WHERE id = ?",
                    new Object[]{gameId},(rs, rowNum) -> new Game(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("platform")
                    )
            );

        }catch (EmptyResultDataAccessException ex){
            return null;
        }

    }

    //Get all games
    public List<Game> getGameList() {
        return jdbcTemplate.query(
                "SELECT * FROM gametable",
                (rs, rowNum) ->
                        new Game(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("platform")
                         )
        );
    }

    //Update a game entry using id
    public int gameUpdate(Integer gameId, Game newGame) {
        return jdbcTemplate.update("UPDATE gametable  SET id = ?, name = ?, platform = ? WHERE id = ?",newGame.getId(),newGame.getName(),newGame.getPlatform(),gameId);
    }

    //Delete game entry
    public int deleteGame(Integer gameId) {
        return jdbcTemplate.update("DELETE FROM gametable WHERE id = ?",gameId);
    }

    public int deleteAllGame() {
        return jdbcTemplate.update("DELETE FROM gametable");
    }
}

