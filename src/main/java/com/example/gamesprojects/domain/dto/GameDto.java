package com.example.gamesprojects.domain.dto;

import lombok.Builder;

@Builder
public class GameDto {

    private Long id;
    private String title;
    private String author;
    private String year;


    public GameDto(Long id, String title, String author, String year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;

    }

    public GameDto() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

}