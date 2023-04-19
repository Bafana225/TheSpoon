package com.memel.TheSpoon.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(1)
    private Integer nbrAdulte;

    @NotNull
    @Min(0)
    private Integer nbrEnfant;

    @NotNull
    @ManyToOne
    @JoinColumn(name="horaire")
    private Horaires horaires;

    @NotNull
    @ManyToOne
    @JoinColumn(name="restaurant")
    private Restaurant restaurant;

}









