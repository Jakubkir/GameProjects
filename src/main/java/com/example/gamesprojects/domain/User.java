package com.example.gamesprojects.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "USER_ID", unique = true)
    private Long id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "USER_STATUS")
    private boolean status;

    public User(Long id, String login, String password, String email, String address, boolean status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.address = address;
        this.status = status;
    }

    public User(Long id, String login, String email, String password, String address) {
    }
}