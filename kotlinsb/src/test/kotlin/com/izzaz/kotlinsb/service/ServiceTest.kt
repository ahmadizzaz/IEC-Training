package com.izzaz.kotlinsb.service

import com.izzaz.kotlinsb.entity.Game
import com.izzaz.kotlinsb.repository.GameRepo
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest

@RunWith(MockitoJUnitRunner::class)
@SpringBootTest
class ServiceTest() {

    @InjectMocks
    private lateinit var gameService: GameService

    @Mock
    private lateinit var gameRepo: GameRepo

    @Test
    fun getGameListTest() {
        `when`(gameRepo.getGameList()).thenReturn(listOf(
                Game(10,"GTA5","PC"),
                Game(11,"Forza : Horizon","Xbox")
        ))
        val gameList : List<Game> = gameService.getGameList()
        assertEquals(10, gameList[0].id)
        assertEquals("GTA5", gameList[0].name)
        assertEquals("PC", gameList[0].platform)
        assertEquals(11, gameList[1].id)
        assertEquals("Forza : Horizon", gameList[1].name)
        assertEquals("Xbox", gameList[1].platform)
    }

    @Test
    fun getGameTest(){
        `when`(gameRepo.getGame(10)).thenReturn(Game(10,"GTA5","PC"))
        val game : Game? = gameService.getGame(10)
        assertEquals(10, game?.id)
        assertEquals("GTA5", game?.name)
        assertEquals("PC", game?.platform)
    }

    @Test
    fun getEmptyGameTest(){
        `when`(gameRepo.getGame(1)).thenReturn(null)
        val game : Game? = gameService.getGame(1)
        assertNull(game)
    }

}