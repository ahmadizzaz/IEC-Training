package com.izzaz.kotlinsb.controller

import com.izzaz.kotlinsb.entity.Game
import com.izzaz.kotlinsb.service.GameService
import org.hamcrest.Matchers.hasSize
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.mockito.Mockito.`when`

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest(GameController::class)
class ControllerTest(@Autowired
                     private var mockMvc: MockMvc) {

    @MockBean
    private lateinit var gameService: GameService

    @InjectMocks
    private lateinit var gameController: GameController

    @Before
    fun init(){
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders.standaloneSetup(gameController).build()
    }

    @Test
    fun getGameListTest(){
        `when`(gameService.getGameList()).thenReturn(listOf(
                Game(10,"GTA5","PC"),
                Game(11,"Forza : Horizon","Xbox")
        ))
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/game"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$",hasSize(2)))
        )
    }
}
