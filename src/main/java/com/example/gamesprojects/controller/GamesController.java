package com.example.gamesprojects.controller;

import com.example.gamesprojects.domain.Game;
import com.example.gamesprojects.domain.dto.GameDto;
import com.example.gamesprojects.exception.GameNotFoundException;
import com.example.gamesprojects.mapper.GameMapper;
import com.example.gamesprojects.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/games")
@RequiredArgsConstructor
public class GamesController {

    private final GameService gameService;
    private final GameMapper gameMapper;

    @GetMapping
    public ResponseEntity<List<GameDto>> getGames() {
        List<Game> games = gameService.getAllGames();
        return ResponseEntity.ok(gameMapper.mapToGameDtoList(games));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<GameDto> getGame(@PathVariable Long id) throws GameNotFoundException {
        return ResponseEntity.ok(gameMapper.mapToGameDto(gameDbService.getGames(gameId)));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) throws GameNotFoundException {
        gameService.deleteGame(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GameDto> updateGame(@@RequestBody GameDto gameDto) {
        Game game = gameMapper.mapToGame(gameDto);
        Game savedgame = gameService.saveGame(game);
        return ResponseEntity.ok(gameMapper.mapToGameDto(savedgame));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGame(@RequestBody GameDto gameDto) {
        Game game = gameMapper.mapToGame(gameDto);
        gameService.saveGame(game);
        return ResponseEntity.ok().build();
    }
}
}