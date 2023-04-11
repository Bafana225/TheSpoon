package com.memel.TheSpoon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class RestaurantDTO {

        private long id;

        private String nom;

        private int nbCouverts;

        private boolean accessibilitePmr;

        private float prixMoyen;

        private String adresse;

        //
        private List<String> horaires;
        //
}

