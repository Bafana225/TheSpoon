package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Horaires;
import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.repository.HorairesRepository;
import com.memel.TheSpoon.repository.ReservationRepository;
import com.memel.TheSpoon.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private HorairesRepository horairesRepository;
    @Autowired
    private RestaurantServiceImpl restaurantService;

    @Override
    public Reservation saveReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservationInServiceImpl(Reservation r) {
        Optional<Reservation> existingReservation = reservationRepository.findById(r.getId());
        if (existingReservation.isPresent()) {
            Reservation updatedReservation = existingReservation.get();
            updatedReservation.setRestaurant(r.getRestaurant());
            updatedReservation.setNbAdultes(r.getNbAdultes());
            updatedReservation.setNbEnfants(r.getNbEnfants());
            updatedReservation.setHeureReservation(r.getHeureReservation());
            updatedReservation.setRestaurant(r.getRestaurant());
            return reservationRepository.save(updatedReservation);
        }
        return null;
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
        return getReservationById(id);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée !"));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }


    // FONCTIONS SPECIFIQUES

    public Reservation addReservation(Reservation reservation) { return reservationRepository.save(reservation); }


    public List<Reservation> getReservationsByIdRestaurant(long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            Optional<List<Reservation>> listeReservation = reservationRepository.findByRestaurant(restaurant.get());
            return listeReservation.orElse(new ArrayList<>());
        }
        return new ArrayList<>();
    }

}
