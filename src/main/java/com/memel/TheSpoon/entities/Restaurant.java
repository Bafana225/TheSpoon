package com.memel.TheSpoon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    private Short nbCouverts;

    @Column(length = 50)
    private Boolean accessibilitePmr;

    @Column(length = 50)
    private Double prixMoyen;

    //Associations
    @ManyToMany(mappedBy = "restaurants", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Horaires> horaires;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Reservation.class, mappedBy = "restaurant")
    @JsonIgnore
    private List<Reservation> reservation;


}