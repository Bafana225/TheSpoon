package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Horaires;
import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.repository.HorairesRepository;
import com.memel.TheSpoon.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    HorairesRepository horairesRepository;
    @Override
    public Restaurant saveRestaurant(Restaurant r) {
        return restaurantRepository.save(r);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant r) {
        return restaurantRepository.save(r);
    }

    @Override
    public void deleteRestaurant(Restaurant r) {
        restaurantRepository.delete(r);
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    /**
     * Ajoute un restaurant
     * @param Restaurants L'object restaurant a ajouter
     * @return L'object restaurant ajouter
     */
    public Restaurant addRestaurant(Restaurant Restaurants){
        return restaurantRepository.save(Restaurants);
    }




    public List<Object> addHoraire(long id_Horaire, long id_Restaurant) {
        Restaurant restaurant = getRestaurant(id_Restaurant);
        Horaires horaires = horairesRepository.findHorairesById(id_Horaire);
        if (restaurant == null) {
            return Arrays.asList("Restaurant inexistant", HttpStatus.NOT_FOUND);
        }
        if (horaires == null) {
            return Arrays.asList("Horaire inexistant", HttpStatus.NOT_FOUND);
        }
        restaurant.getHoraires().add(horaires);
        restaurantRepository.save(restaurant);
        horairesRepository.save(horaires);
        return Arrays.asList("Horaire a été ajouté avec succès : " + restaurant.getNom() + " " + "Heure : " + horaires.getHoraire(), HttpStatus.OK);
    }

    public boolean checkOpened(Restaurant restaurant, Horaires horaire) {
        return restaurant.getHoraires().contains(horaire);
    }

}
