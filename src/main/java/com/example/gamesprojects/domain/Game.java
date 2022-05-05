package com.example.gamesprojects.domain;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;;import java.util.Collection;

@Builder
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private String year;


    @ManyToOne
    @JoinColumn(name = "collection_id")
    private Collection collection;

    public Game(Long id, String title, String author, String year, Collection collection) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.collection = collection;
    }

    public Game() {
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


    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}