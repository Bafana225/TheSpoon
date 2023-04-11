package com.memel.TheSpoon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurant")
    private long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 300)
    private String imageUrl;

    @Column(length = 50)
    private String adresse;

    @Column(length = 50)
    private int nbCouverts;

    @Column(length = 50)
    private boolean accessibilitePmr;

    @Column(length = 50)
    private float prixMoyen;

    ///

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Set<Horaires> horaires;

}
