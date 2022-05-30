package com.example.gamesprojects.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReferDto {

    private Long id;
    private String author;
    private String content;
}

