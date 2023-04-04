package com.memel.TheSpoon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 50)
    private String adresse;

    @Column(length = 50)
    private String ville;

    @Column(length = 50)
    private String codePostal;

    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "personne")
    @JsonIgnore
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "id_type_personne")
    private TypePersonne typePersonne;

}