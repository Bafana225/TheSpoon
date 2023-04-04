package com.memel.TheSpoon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation", nullable = false)
    private long id;

    @Column(length = 50)
    private String nbAdultes;

    @Column(length = 50)
    private String nbEnfants;

    @Column(length = 50)
    private String heureReservation;

    @JsonIgnore
    @ManyToMany(mappedBy = "biensImmobiliers", cascade = CascadeType.ALL)
    private List<Personne> personnes;

    @ManyToOne
    @JoinColumn(name = "id_restaurant")
    private Restaurant resataurant;
}
