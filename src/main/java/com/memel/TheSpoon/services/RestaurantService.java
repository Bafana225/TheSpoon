package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Horaires;
import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.repository.HorairesRepository;
import com.memel.TheSpoon.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    private ReservationService reservationService;

    public RestaurantService(RestaurantRepository restaurantRepository, ReservationService reservationService) {
        this.restaurantRepository = restaurantRepository;
        this.reservationService = reservationService;
    }

    /**
     * Retourne une liste d'objet Restaurant
     * @return List<Restaurant> List<obj>
     */
    public List<Restaurant> listResto() {
        return this.restaurantRepository.findAll();
    }

    /**
     * Cré un restaurant
     * @param resto <obj>
     * @return Restaurant <obj>
     */
    public Restaurant ajoutResto(Restaurant resto) {
        return this.restaurantRepository.save(resto);
    }

    /**
     * Modifie un restaurant
     * @param resto <obj>
     * @return Restaurant <obj>
     */
    public Restaurant editResto(Restaurant resto) {
        return this.restaurantRepository.save(resto);
    }

    /**
     * Supprime un restaurant à partir de son id
     * @param id
     */
    public void supRestoById(Long id) {
        if(restaurantRepository.existsById(id)){
            // Avant de supprimer le restaurant on supprime les réservations
            // Récupère les réservations du restaurant
            List<Reservation> lstResa = reservationService.getReservationsByIdResto(id);
            // Supprime chaque réservation
            if(!lstResa.isEmpty()){
                for(Reservation resa : lstResa){
                    reservationService.supResaById(resa.getId());
                }
            }
            // Supprime le restaurant
            this.restaurantRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant inexistant");
        }
    }
}
