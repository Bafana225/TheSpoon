package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Override
    public Reservation saveReservation(Reservation r) {
        return reservationRepository.save(r);
    }
    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }
    @Override
    public void deleteReservation(Reservation r) {
        reservationRepository.delete(r);
    }
    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }
    @Override
    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).get();
    }
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
