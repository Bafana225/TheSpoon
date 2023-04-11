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
    @Column(name = "id_horaires")
    private Long id;
    @Column
    private String horaire;

    ///

    public Horaires(String valeur) {
        this.horaire = valeur;
    }


}
