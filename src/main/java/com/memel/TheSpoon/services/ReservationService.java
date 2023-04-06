package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation r);
    Reservation updateReservationInServiceImpl(Reservation r);
    void deleteReservation(Reservation r);
    void deleteReservationById(Long id);
    Reservation getReservation(Long id);
    List<Reservation> getAllReservations();

}

