package com.memel.TheSpoon.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "type_personne")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TypePersonne {

    @Id
    @Column(name = "id_type_personne")
    private Long id;

    @Column(name = "libelle")
    private String libelle;

}