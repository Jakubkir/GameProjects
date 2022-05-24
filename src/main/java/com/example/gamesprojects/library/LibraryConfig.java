package com.example.gamesprojects.library;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class LibraryConfig {

    @Value("${openlibrary.api.endpoint}")
    private String openLibraryApiEndpoint;
}