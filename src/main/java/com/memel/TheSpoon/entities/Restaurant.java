package com.memel.TheSpoon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    @NotNull
    @NotEmpty
    @NotBlank
    private String nom;

    @Column(length = 120)
    @NotNull
    @NotEmpty
    @NotBlank
    private String adresse;

    @NotNull
    @Min(10)
    @Max(100)
    private Integer nbrplace;

    @NotNull
    private Boolean pmr;

    @NotNull
    @Min(1)
    private Integer prix;

    @OneToMany(targetEntity = Reservation.class, mappedBy ="restaurant", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="horaire",
            joinColumns = {@JoinColumn(name="idRestaurant")},
            inverseJoinColumns = {@JoinColumn(name="idHoraire")})
    private List<Horaires> horaires = new ArrayList<>();

}
