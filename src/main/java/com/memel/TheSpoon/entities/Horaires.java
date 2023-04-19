package com.memel.TheSpoon.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "horaire")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Horaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    @NotBlank
    private String horaire;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy="horaires")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Restaurant> retaurants = new ArrayList<>();

    @OneToMany(targetEntity = Reservation.class, mappedBy ="horaire", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Reservation> reservations = new ArrayList<>();

}
