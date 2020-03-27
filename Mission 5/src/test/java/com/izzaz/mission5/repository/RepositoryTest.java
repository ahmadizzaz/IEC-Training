package com.izzaz.mission5.repository;


import com.izzaz.mission5.entity.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void testAddGame(){
        Game game = new Game(10,"Zelda","Switch");
        gameRepository.addGame(game);
        Game tempGame = gameRepository.getGame(game.getId());
        assertEquals(tempGame.getId(),game.getId());
        assertEquals(tempGame.getName(),game.getName());
        assertEquals(tempGame.getPlatform(),game.getPlatform());
    }

    @Test
    public void testGetGameList() {
        List<Game> gameList = gameRepository.getGameList();
        assertThat(gameList).hasSize(2);

    }

    @Test
    public void testGetGame() {
        Game game = gameRepository.getGame(10);
        assertNotNull(game);
    }

    @Test
    public void testUpdateGame() {
        Game game = new Game(20,"LoL", "PC");
        gameRepository.addGame(game);
        Game game_2 = gameRepository.getGame(game.getId());
        assertEquals(game_2.getId(),game.getId());
        assertEquals(game_2.getName(),game.getName());
        assertEquals(game_2.getPlatform(),game.getPlatform());
        Game game_3 = new Game(game_2.getId(), "Minecraft", "Mobile");
        gameRepository.gameUpdate(game_3.getId(), game_3);
        Game game_4 = gameRepository.getGame(game_3.getId());
        assertEquals(game_4.getName(), game_3.getName());
        assertEquals(game_4.getPlatform(), game_3.getPlatform());
    }

    @Test
    public void testDeleteGame(){
        Game game = gameRepository.getGame(10);
        assertNotNull(game);
        gameRepository.deleteGame(game.getId());
        Game tempGame = gameRepository.getGame(10);
        assertNull(tempGame);
    }
}
