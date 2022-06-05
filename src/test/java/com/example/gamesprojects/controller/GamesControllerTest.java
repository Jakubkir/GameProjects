package com.example.gamesprojects.controller;

import com.example.gamesprojects.domain.Game;
import com.example.gamesprojects.domain.dto.GameDto;
import com.example.gamesprojects.mapper.GameMapper;
import com.example.gamesprojects.service.GameService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class GamesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @MockBean
    private GameMapper gameMapper;

    @Test
    void shouldGetGames() throws Exception {
        //Given
        List<Game> bGames = List.of(Game.builder()
                .id(1L)
                .title("title")
                .author("author")
                .year("year")
                .build());
        List<GameDto> bGameDtos = List.of(GameDto.builder()
                .id(1L)
                .title("title")
                .author("author")
                .year("year")
                .build());

        when(gameService.getAllGames()).thenReturn(bGames);
        when(gameMapper.mapToGameDtoList(bGames)).thenReturn(bGameDtos);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/Games")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect((MockMvcResultMatchers.status()).is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Matchers.is("title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].author", Matchers.is("author")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].year", Matchers.is("year")));
    }

    @Test
    void shouldGetBGame() throws Exception {
        //Given
        Game game = Game.builder()
                .id(1L)
                .title("title")
                .author("author")
                .year("year")
                .build();
        GameDto gameDto = GameDto.builder()
                .id(1L)
                .title("title")
                .author("author")
                .year("year")
                .build();

        when(gameService.getGame(game.getId())).thenReturn(game);
        when(gameMapper.mapToGameDto(game)).thenReturn(gameDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/Games/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect((MockMvcResultMatchers.status()).is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author", Matchers.is("author")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.year", Matchers.is("year")));
    };

    @Test
    void shouldDeleteBGame() throws Exception {
        //Given
        doNothing().when(gameService).deleteGame(anyLong());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/Games/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void shouldUpdateGame() throws Exception {
        //Given
        Game game = Game.builder()
                .id(1L)
                .title("title")
                .author("author")
                .year("year")
                .build();
        GameDto gameDto = GameDto.builder()
                .id(1L)
                .title("title")
                .author("author")
                .year("year")
                .build();

        when(gameMapper.mapToGame(any(GameDto.class))).thenReturn(game);
        when(gameService.saveGame(game)).thenReturn(game);
        when(gameMapper.mapToGameDto(game)).thenReturn(gameDto);

        Gson gson = new Gson();
        String json = gson.toJson(gameDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(json))
                .andExpect((MockMvcResultMatchers.status()).is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author", Matchers.is("author")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.year", Matchers.is("year")));
    }

    @Test
    void shouldCreateGame() throws Exception {
        //Given
        Game game = Game.builder()
                .id(1L)
                .title("title")
                .author("author")
                .year("year")
                .build();
        GameDto gameDto = GameDto.builder()
                .id(1L)
                .title("title")
                .author("author")
                .year("year")
                .build();

        when(gameMapper.mapToGame(gameDto)).thenReturn(game);
        when(gameService.saveGame(game)).thenReturn(game);

        Gson gson = new Gson();
        String json = gson.toJson(gameDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/bGames")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(json))
                .andExpect((MockMvcResultMatchers.status()).is(200));
    }
}
