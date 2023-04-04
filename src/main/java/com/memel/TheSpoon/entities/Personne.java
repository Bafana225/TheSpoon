package com.memel.TheSpoon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "personne")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonne", nullable = false)
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "personneReserveation",
            joinColumns = { @JoinColumn(name = "idPersonne") },
            inverseJoinColumns = { @JoinColumn (name = "idReservation")}
    )
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "id_type_personne")
    private TypePersonne typePersonne;

}