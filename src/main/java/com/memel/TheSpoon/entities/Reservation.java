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
    private Integer nbAdultes;

    @Column(length = 50)
    private Integer nbEnfants;

    @Column
    private boolean accessiblePmr;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

   @ManyToOne
   @JoinColumn(name = "horaires_id")
   private Horaires horaires;
}
