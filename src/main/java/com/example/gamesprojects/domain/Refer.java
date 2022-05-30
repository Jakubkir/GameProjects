package com.example.gamesprojects.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Entity
    @Table(name="Refers")
    public class Refer {

        @Id
        @GeneratedValue
        @NotNull
        @Column(name="id", unique=true)
        private Long id;

        @Column(name="author")
        private String author;

        @Column(name="content")
        private String content;

        public Refer(String author, String content) {
            this.author = author;
            this.content = content;
        }
}
