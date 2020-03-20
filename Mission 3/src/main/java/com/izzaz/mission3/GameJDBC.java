package com.izzaz.mission3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GameJDBC implements GameRepository {

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
        return jdbcTemplate.queryForObject(
                "SELECT * FROM gametable WHERE id = ?",
                new Object[]{gameId},(rs, rowNum) -> new Game(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("platform")
                )
        );
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
}

