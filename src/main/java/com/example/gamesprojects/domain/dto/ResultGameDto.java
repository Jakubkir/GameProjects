package com.example.gamesprojects.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultGameDto {

    @JsonProperty("title")
    private String title;

    @JsonProperty("author_name")
    private List<String> authors;

    @JsonProperty("first_publish_year")
    private int first_publish_year;
}