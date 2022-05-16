package com.example.gamesprojects.mapper;

import com.example.gamesprojects.domain.Game;
import com.example.gamesprojects.domain.dto.GameDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class GameMapper {
    public Game mapToGame(final GameDto gameDto) {
        return Game.builder()
                .id(gameDto.getId())
                .title(gameDto.getTitle())
                .author(gameDto.getAuthor())
                .year(gameDto.getYear())
                .build();
    }

    public GameDto mapToGameDto(final Game game) {
        return GameDto.builder()
                .id(game.getId())
                .title(game.getTitle())
                .author(game.getAuthor())
                .year(game.getYear())
                .build();
    }

    public List<GameDto> mapToGameDtoList(final List<Game> gameList) {
        return gameList.stream()
                .map(this::mapToGameDto)
                .collect(Collectors.toList());
    }
}
