package com.izzaz.mission8.controller;

import com.izzaz.mission8.entity.Game;
import com.izzaz.mission8.service.GameService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/*
import com.izzaz.mission5.entity.Game;
import com.izzaz.mission5.service.GameService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
*/


@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @InjectMocks
    private GameController gameController;

    @Before
    public void init() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();
    }

    @Test //Test for GET method for game list
    public void getGameListTest() throws Exception {

        when(gameService.getGameList()).thenReturn(Arrays.asList(
                new Game(30,"Zelda","Switch"),
                new Game(31,"ACNH","Switch")
        ));
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/game"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id",is(30)))
                .andExpect(jsonPath("$[0].name",is("Zelda")))
                .andExpect(jsonPath("$[0].platform",is("Switch")))
                .andExpect(jsonPath("$[1].id",is(31)))
                .andExpect(jsonPath("$[1].name",is("ACNH")))
                .andExpect(jsonPath("$[1].platform",is("Switch")));
    }

    @Test
    public void getEmptyGameListTest() throws Exception {
        when(gameService.getGameList()).thenReturn(Collections.emptyList());
        mockMvc.perform(
                MockMvcRequestBuilders.get("/game"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getGameTest() throws Exception {
        when(gameService.getGame(30)).thenReturn(new Game(30, "Zelda", "Switch"));
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/game/30"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(30)))
                .andExpect(jsonPath("$.name", is("Zelda")))
                .andExpect(jsonPath("$.platform", is("Switch")));
    }

    @Test
    public void getEmptyGameTest() throws Exception {
        when(gameService.getGame(30)).thenReturn(null);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/game/30"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }
}
