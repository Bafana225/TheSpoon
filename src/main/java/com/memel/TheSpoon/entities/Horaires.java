package com.memel.TheSpoon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Horaires")
public class Horaires {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_horaires")
    private Long id;


    @Column
    private String horaires;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Horaires",
            joinColumns = @JoinColumn(name = "id_horaires"),
            inverseJoinColumns = @JoinColumn(name = "id_restaurant"))
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Restaurant> restaurants = new ArrayList<>();



    @OneToMany(fetch = FetchType.LAZY, targetEntity = Reservation.class, mappedBy = "horaires")
    @JsonIgnore
    private List<Reservation> reservation;
}