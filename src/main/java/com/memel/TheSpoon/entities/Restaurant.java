package com.memel.TheSpoon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurant")
@Getter
@Setter

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String adresse;

    @Column(length = 50)
    private Integer nbCouverts;

    @Column(length = 50)
    private Boolean accessibilitePmr;

    @Column(length = 50)
    private Double prixMoyen;

    // Relation @OneToMany entre Restaurant et Reservation
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation> reservations;

    // Relation @ManyToMany entre Restaurant et Horaires
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "restaurant_horaires",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "horaires_id"))
    private List<Horaires> horaires;
}
