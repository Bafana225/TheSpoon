package com.memel.TheSpoon.dto;

import com.memel.TheSpoon.entities.Horaires;
import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.repository.HorairesRepository;
import com.memel.TheSpoon.repository.RestaurantRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@NoArgsConstructor
@Service
public class Mapper {
    @Autowired
    private HorairesRepository horairesRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant restaurantDTOtoRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDTO.getId());
        restaurant.setNom(restaurantDTO.getNom());
        restaurant.setNbCouverts(restaurantDTO.getNbCouverts());
        restaurant.setAccessibilitePmr(restaurantDTO.isAccessibilitePmr());
        restaurant.setPrixMoyen(restaurantDTO.getPrixMoyen());
        restaurant.setAdresse(restaurantDTO.getAdresse());
        restaurant.setHoraires(new HashSet<>());
        // Vérification de la présence d'horaires
        if (restaurantDTO.getHoraires() != null) {
            for (String horaire : restaurantDTO.getHoraires()) {
                Optional<Horaires> horairesOptional = horairesRepository.findByValeur(horaire);
                horairesOptional.ifPresent(restaurant.getHoraires()::add);
            }
        }
        return restaurant;
    }

    public Reservation reservationDTOtoReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setNbAdultes(reservationDTO.getNbAdultes());
        reservation.setNbEnfants(reservationDTO.getNbEnfants());
        Optional<Horaires> horairesOptional = horairesRepository.findByValeur(reservationDTO.getHeureReservation());
        horairesOptional.ifPresent(reservation::setHeureReservation);
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(reservationDTO.getId());
        restaurantOptional.ifPresent(reservation::setRestaurant);
        return reservation;
    }

}