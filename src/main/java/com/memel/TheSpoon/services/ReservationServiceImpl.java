package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Horaires;
import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.repository.ReservationRepository;
import com.memel.TheSpoon.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
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


    // Fonctions spécifiques
    public List<Reservation> getReservationByIdRestaurant(Long id){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<Reservation> reservations = new ArrayList<Reservation>();
        Restaurant restaurant = new Restaurant();
        for(Restaurant r : restaurants){
            if(r.getId() == id){
                restaurant = r;
                break;
            }
        }
        reservations = restaurant.getReservation();

        return reservations;
    }

    //Fonction 'getReservationByHoraire'
    public List<Reservation> getReservationByHoraire(List<Reservation> reservations, Horaires horaire){
        List<Reservation> reservationsFiltre = new ArrayList<>();

        for(Reservation reservation : reservations){
            if(reservation.getHoraires() == horaire){
                reservationsFiltre.add(reservation);
            }
        }

        return reservationsFiltre;
    }
}
