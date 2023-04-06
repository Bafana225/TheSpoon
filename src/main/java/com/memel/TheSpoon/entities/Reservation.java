package com.memel.TheSpoon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Reservation")
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

    /** ManyToOne Reservation --> Restaurant **/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;

    /** ManyToOne Reservation --> Horaire **/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_horaires")
    private Horaires horaires;

}









