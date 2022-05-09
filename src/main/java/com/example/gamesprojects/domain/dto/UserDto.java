package com.example.gamesprojects.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private Long id;
    private String login;
    private String email;
    private String password;
    private String address;
    private boolean status;
}

