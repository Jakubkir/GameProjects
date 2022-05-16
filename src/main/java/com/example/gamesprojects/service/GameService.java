package com.example.gamesprojects.service;

import com.example.gamesprojects.domain.Game;
import com.example.gamesprojects.exception.GameNotFoundException;
import com.example.gamesprojects.respository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {


    private final GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGame(final Long id) throws GameNotFoundException {
        return gameRepository.findById(id).orElseThrow(GameNotFoundException::new);
    }

    public Game saveGame(final Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(final Long id) throws GameNotFoundException {
        try {
            gameRepository.deleteById(id);
        } catch (Exception e) {
            throw new GameNotFoundException();
        }
    }
}