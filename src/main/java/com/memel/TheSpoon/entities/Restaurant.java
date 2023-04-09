package com.memel.TheSpoon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    @Column(name = "id_restaurant")
    private long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 300)
    private String imageUrl;

    @Column(length = 50)
    private String adresse;

    @Column(length = 50)
    private Integer nbCouverts;

    @Column(length = 50)
    private Boolean accessibilitePmr;

    @Column(length = 50)
    private Double prixMoyen;



    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Horaires.class)
    private List<Horaires> horaires;


    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reservation> reservations;


}
