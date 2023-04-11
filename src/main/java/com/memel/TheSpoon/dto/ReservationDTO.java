package com.memel.TheSpoon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReservationDTO {

    private long id;

    private int nbAdultes;

    private int nbEnfants;


    private String heureReservation;

    private Long restaurant;
}
