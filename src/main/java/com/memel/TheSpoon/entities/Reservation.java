package com.memel.TheSpoon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(length = 50)
    private Short nbAdultes;

    @Column(length = 50)
    private Short nbEnfants;

    @Column(length = 50)
    private String heureReservation;

    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
