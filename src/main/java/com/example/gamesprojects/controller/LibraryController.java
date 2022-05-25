package com.example.gamesprojects.controller;

import com.example.gamesprojects.domain.dto.ResultDto;
import com.example.gamesprojects.domain.dto.ResultGameDto;
import com.example.gamesprojects.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class LibraryController {

    private LibraryService LibraryService;

    @GetMapping(value = "/author/{keyword}")
    public List<ResultGameDto> getGameByAuthor(@PathVariable String keyword) {
        ResultDto resultDto = LibraryService.fetchGameByAuthor(keyword);

        List<ResultGameDto> resultGameDtoList = new ArrayList<>();
        resultGameDtoList.addAll(resultDto.getGames());

        return resultGameDtoList;
    }

    @GetMapping(value = "/title/{keyword}")
    public List<ResultGameDto> getGameByTitle(@PathVariable String keyword) {
        ResultDto resultDto = LibraryService.fetchGameByTitle(keyword);

        List<ResultGameDto> resultGameDtoList = new ArrayList<>();
        resultGameDtoList.addAll(resultDto.getGames());

        return resultGameDtoList;
    }
}
