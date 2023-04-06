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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Arrays;
import java.util.List;
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

    public List<Object> addReservation(Reservation reservation) {

        Restaurant restaurant = restaurantRepository.findById(reservation.getRestaurant().getId())
                .orElseThrow(() -> new RuntimeException("Restaurant non valide !"));
        Horaires horaires = horairesRepository.findById(reservation.getHoraires().getId())
                .orElseThrow(() -> new RuntimeException("Horaire non valide !"));

        if (restaurant == null) {
            return Arrays.asList("Restaurant non valide !", HttpStatus.NOT_FOUND);
        }

        if (horaires == null) {
            return Arrays.asList("Horaire non valide !", HttpStatus.NOT_FOUND);
        }

        if (!restaurantService.checkOpened(restaurant, horaires)) {
            return Arrays.asList("Le restaurant est fermé ! ", HttpStatus.FORBIDDEN);
        }

        List<Reservation> reservationsByHoraire = getReservationByHoraire(horaires.getReservations(), horaires);
        int sommePersonnesReservees = sommePersonnesByReservation(reservationsByHoraire) + reservation.getNbAdultes() + reservation.getNbEnfants();

        if (sommePersonnesReservees > restaurant.getNbCouverts()) {
            return Arrays.asList("Nous n'avons malheureusement plus assez de places disponibles !", HttpStatus.FORBIDDEN);
        }

        reservationRepository.save(reservation);
        return Arrays.asList("Réservation validée !", HttpStatus.OK);
    }


    public Reservation updateReservationInServiceImpl(Reservation reservation) {
        Restaurant restaurant = restaurantRepository.findById(reservation.getRestaurant().getId())
                .orElseThrow(() -> new RuntimeException("Restaurant non valide !"));
        Horaires horaires = horairesRepository.findById(reservation.getHoraires().getId())
                .orElseThrow(() -> new RuntimeException("Horaire non valide !"));

        Reservation existingReservation = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new RuntimeException("La réservation n'existe pas !"));

        if (!restaurantService.checkOpened(restaurant, horaires)) {
            throw new RuntimeException("Le restaurant est fermé !");
        }

        List<Reservation> reservationsByHoraire = getReservationByHoraire(getReservationsByIdRestaurant(restaurant.getId()), horaires);
        int sommePersonnesReservees = sommePersonnesByReservation(reservationsByHoraire) + reservation.getNbAdultes() + reservation.getNbEnfants();

        if (sommePersonnesReservees > restaurant.getNbCouverts()) {
            throw new RuntimeException("Nous n'avons malheureusement plus assez de places disponibles !");
        }

        existingReservation.setNbAdultes(reservation.getNbAdultes());
        existingReservation.setNbEnfants(reservation.getNbEnfants());
        existingReservation.setRestaurant(reservation.getRestaurant());
        existingReservation.setHoraires(reservation.getHoraires());

        Reservation updatedReservation = reservationRepository.save(existingReservation);
        return updatedReservation;
    }

    // TEST SWAGGER
    public List<Object> getReservationByNomRestaurant(String nomRestaurant) {

        String nomRestaurantNormalise = nomRestaurant.replaceAll("\\s+", "").toLowerCase();

        List<Reservation> reservations = restaurantService.getAllRestaurants().stream()
                .filter(r -> r.getNom().replaceAll("\\s+", "").toLowerCase().equals(nomRestaurantNormalise))
                .flatMap(r -> r.getReservations().stream())
                .collect(Collectors.toList());

        if (reservations.isEmpty()) {
            return Arrays.asList("Aucune réservation pour le restaurant : " + nomRestaurant, HttpStatus.NOT_FOUND);
        }

        return Arrays.asList(reservations, HttpStatus.OK);
    }


    public List<Reservation> getReservationsByIdRestaurant(Long idRestaurant) {
        Restaurant restaurant = restaurantRepository.findById(idRestaurant)
                .orElseThrow(() -> new RuntimeException("Restaurant non valide !"));

        return restaurant.getReservations();
    }

    // Fonction 'getReservationByHoraire'

    public List<Reservation> getReservationByHoraire(List<Reservation> reservations, Horaires horaires) {
        return reservations.stream()
                .filter(r -> r.getHoraires().equals(horaires))
                .collect(Collectors.toList());
    }


    public int sommePersonnesByReservation(List<Reservation> reservations) {
        return reservations.stream()
                .mapToInt(r -> r.getNbAdultes() + r.getNbEnfants())
                .sum();
    }
}
