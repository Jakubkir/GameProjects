package com.example.gamesprojects.controller;

import com.example.gamesprojects.domain.Game;
import com.example.gamesprojects.domain.dto.GameDto;
import com.example.gamesprojects.exception.GameNotFoundException;
import com.example.gamesprojects.mapper.GameMapper;
import com.example.gamesprojects.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

public class ColletionController {
    private final CollectionService collectionService;
    private final CollectionMapper collectionMapper;
    private final GameService gameService;
    private final GameMapper gameMapper;

    public ColletionController() {
    }

    @GetMapping
    public ResponseEntity<List<CollectionDto>> getCollections() {
        List<Collection> collections = collectionService.getAllCollections();
        return ResponseEntity.ok(collectionMapper.mapToCollectionDtoList(collections));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CollectionDto> getCollection(@PathVariable Long id) throws CollectionNotFoundException {
        return new ResponseEntity<>(collectionMapper.mapToCollectionDto(collectionService.getCollection(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteCollection(@PathVariable Long id) throws CollectionNotFoundException {
        collectionService.deleteCollection(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CollectionDto> updateCollection(@RequestBody CollectionDto collectionDto) {
        Collection collection = collectionMapper.mapToCollection(collectionDto);
        Collection savedCollection = collectionService.saveCollection(collection);
        return ResponseEntity.ok(collectionMapper.mapToCollectionDto(savedCollection));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCollection(@RequestBody CollectionDto collectionDto) {
        Collection collection = collectionMapper.mapToCollection(collectionDto);
        collectionService.saveCollection(collection);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}/games")
    public ResponseEntity<List<GameDto>> getGamesInCollection(@PathVariable Long id) throws CollectionNotFoundException {
        List<GameDto> games = gameMapper.mapToGameDtoList(collectionService.getCollection(id).getGames());
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @PostMapping(value = "{id}/games")
    public ResponseEntity<Void> addGameToCollection(@PathVariable Long id, @RequestBody GameDto gameDto) throws CollectionNotFoundException {
        Collection collection = collectionService.getCollection(id);
        Game game = gameMapper.mapToGame(gameDto);
        collection.getGames().add(game);
        game.setCollection(collection);
        gameService.saveGame(game);
        collectionService.saveCollection(collection);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{collectionId}/games/{gameId}")
    public ResponseEntity<Void> deleteGameFromCollection(@PathVariable Long collectionId, @PathVariable Long gameId) throws CollectionNotFoundException, GameNotFoundException {
        Collection collection = collectionService.getCollection(collectionId);
        Game game = gameService.getGame(gameId);
        collection.getGames().remove(game);
        gameService.deleteGame(gameId);
        return ResponseEntity.ok().build();
    }
}
}
