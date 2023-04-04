package com.memel.TheSpoon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonne", nullable = false)
    private long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String adresse;

    @Column(length = 50)
    private String nbCouverts;

    @Column(length = 50)
    private String accessibilitePmr;

    @Column(length = 50)
    private Double prixMoyen;

    @Column(length = 50)
    private String horaires;

    @JsonIgnore
    @ManyToMany(mappedBy = "restaurants", cascade = CascadeType.ALL)
    private List<Personne> personnes;

}