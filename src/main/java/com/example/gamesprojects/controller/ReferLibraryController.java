package com.example.gamesprojects.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/refer")
public class ReferLibraryController {
    private final ReferLibraryService referLibraryService;

    @GetMapping
    public List<ReferLibraryDto> getRandomRefer() {
        return referLibraryService.fetchRandomRefer();
    }
}
