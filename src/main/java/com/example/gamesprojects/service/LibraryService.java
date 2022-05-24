package com.example.gamesprojects.service;


import com.example.gamesprojects.domain.dto.ResultDto;
import com.example.gamesprojects.library.LibraryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryClient LibraryClient;

    public ResultDto fetchGameByAuthor(String keyword) {
        return LibraryClient.getGameByAuthor(keyword);
    }

    public ResultDto fetchGameByTitle(String keyword) {
        return LibraryClient.getGameByTitle(keyword);
    }
}