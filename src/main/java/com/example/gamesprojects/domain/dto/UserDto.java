package com.example.gamesprojects.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private Long id;
    private String login;
    private String email;
    private String password;
    private String address;
    private boolean status;

    public UserDto(Long id, String login, String email, String password, String address) {
    }
}

