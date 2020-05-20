package com.izzaz.kotlinsb.repository

import com.izzaz.kotlinsb.entity.Game
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class GameRepo(@Autowired var jdbcTemplate: JdbcTemplate){

    fun addGame(game: Game) {
        SimpleJdbcInsert(jdbcTemplate).withTableName("gametable").apply {
            execute(
                    mapOf(
                            "id" to game.id,
                            "name" to game.name,
                            "platform" to game.platform
                    ))}
//        jdbcTemplate.update("INSERT INTO gametable VALUES(?,?,?)",game.id,game.name,game.platform)
    }

    fun getGame(gameId : Int) : Game?{
        try{
            return jdbcTemplate.queryForObject("SELECT id,name,platform FROM gametable WHERE id = ?"
            ) { rs: ResultSet, _ : Int ->
                Game(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("platform"))
            }
        }catch (e : Exception){
            return null
        }

    }

    fun getGameList() : List<Game> = jdbcTemplate.query("SELECT id,name,platform FROM gametable") { rs : ResultSet,_ : Int ->
        Game(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("platform"))
    }

    fun gameUpdate(gameId : Int, newGame: Game) : Int = jdbcTemplate.update("UPDATE gametable  SET id = ?, name = ?, platform = ? WHERE id = ?",newGame.id,newGame.name,newGame.platform)

    fun deleteGame(gameId : Int) : Int = jdbcTemplate.update("DELETE FROM gametable WHERE id = ?",gameId)

    fun deleteAllGame() : Int = jdbcTemplate.update("DELETE FROM gametable")


}