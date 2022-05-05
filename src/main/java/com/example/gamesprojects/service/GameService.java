package com.example.gamesprojects.service;

import com.example.gamesprojects.domain.Game;
import com.example.gamesprojects.exception.GameNotFoundException;
import com.example.gamesprojects.respository.GameRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {


    private final GameRespository gameRespository;

    public List<Game> getAllGames() {
        return gameRespository.findAll();
    }

    public Game getGame(final Long id) throws GameNotFoundException {
        return gameRespository.findById(id).orElseThrow(GameNotFoundException::new);
    }

    public Game saveGame(final Game game) {
        return gameRespository.save(game);
    }

    public void deleteGame(final Long id) throws GameNotFoundException {
        try {
            gameRespository.deleteById(id);
        } catch (Exception e) {
            throw new GameNotFoundException();
        }
    }
}