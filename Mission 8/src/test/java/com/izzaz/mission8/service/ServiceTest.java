package com.izzaz.mission8.service;

import com.izzaz.mission8.entity.Game;
import com.izzaz.mission8.repository.GameRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @InjectMocks
    private GameService gameService;

    @Mock
    private GameRepository gameRepository;

    @Test
    public void getGameListTest(){
        Mockito.when(gameRepository.getGameList()).thenReturn(Arrays.asList(
           new Game(1,"GTA5","PC"),
           new Game(2,"NFS:Carbon","PS2")
        ));
        List<Game> gameList = gameService.getGameList();
        assertEquals(1, gameList.get(0).getId());
        assertEquals("GTA5", gameList.get(0).getName());
        assertEquals("PC", gameList.get(0).getPlatform());
        assertEquals(2, gameList.get(1).getId());
        assertEquals("NFS:Carbon", gameList.get(1).getName());
        assertEquals("PS2", gameList.get(1).getPlatform());

    }



    @Test
    public void getGameTest(){
        Mockito.when(gameRepository.getGame(1)).thenReturn(new Game(1,"GTA5","PC"));
        Game game = gameService.getGame(1);
        assertEquals(1, game.getId());
        assertEquals("GTA5", game.getName());
        assertEquals("PC", game.getPlatform());
    }

    @Test
    public void getEmptyGameTest(){
        Mockito.when(gameRepository.getGame(1)).thenReturn(null);
        Game game = gameService.getGame(1);
        assertNull(game);
    }

}
