package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Personne;
import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.repository.PersonneRepository;
import com.memel.TheSpoon.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService{

    @Autowired
    PersonneRepository personneRepository;

    @Autowired
    ReservationRepository reservationRepository;

    public Personne findPersonneById(Long id) {
        return personneRepository.findPersonneById(id);
    }

    @Override
    public Personne savePersonne(Personne p) {
        return personneRepository.save(p);
    }

    @Override
    public Personne updatePersonne(Personne p) {
        return personneRepository.save(p);
    }

    @Override
    public void deletePersonne(Personne p) {
        personneRepository.delete(p);
    }

    @Override
    public void deletePersonneById(Long id) {
        personneRepository.deleteById(id);
    }

    @Override
    public Personne getPersonne(Long id) {
        return personneRepository.findById(id).get();
    }

    @Override
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

    public Personne addReservation(Long idPersonne , Long idReservation) {
        Reservation reservation = reservationRepository.findReservationById(idReservation);
        Personne personne = findPersonneById(idPersonne);
        if (personne.getReservations() != null) {
            personne.getReservations().add(reservation);
            reservation.setPersonne(personne);
            reservationRepository.save(reservation);
        }
        else{
            List<Reservation> reservations = new ArrayList<>();
            reservations.add(reservation);
            personne.setReservations(reservations);
        }
        return personneRepository.save(personne);
    }

    public Personne deleteReservation(Long idPersonne ,Long idReservation) {
        Reservation reservation = reservationRepository.findReservationById(idReservation);
        Personne personne = findPersonneById(idPersonne);
        if (personne.getReservations() != null) {
            personne.getReservations().remove(reservation);
            reservation.setPersonne(personne);
            reservationRepository.save(reservation);
        }
        else{
            System.out.println("pas de réservations en base de données");
        }
        return personneRepository.save(personne);
    }

}


