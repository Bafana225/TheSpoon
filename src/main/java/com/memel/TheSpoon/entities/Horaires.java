package com.memel.TheSpoon.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "horaires")
public class Horaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String horaire;

    @ManyToMany(mappedBy = "horaires", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "horaires", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation> reservations;
}
