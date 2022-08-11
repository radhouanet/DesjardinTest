package com.desjardins.test.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Acteur> acteurs;

}