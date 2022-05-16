package com.example.gamesprojects.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "collections")
public class Collection {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            targetEntity = Game.class,
            mappedBy = "collection",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Game> books = new ArrayList<>();

    public Collection(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

