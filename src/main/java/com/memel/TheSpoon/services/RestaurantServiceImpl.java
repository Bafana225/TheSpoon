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


    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        return restaurantRepository.findById(id)
                .map(r -> {
                    r.setNom(restaurant.getNom());
                    r.setAdresse(restaurant.getAdresse());
                    r.setNbCouverts(restaurant.getNbCouverts());
                    r.setPrixMoyen(restaurant.getPrixMoyen());
                    r.setAccessibilitePmr(restaurant.getAccessibilitePmr());
                    r.setHoraires(restaurant.getHoraires());
                    r.setReservations(restaurant.getReservations());
                    return restaurantRepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Restaurant non trouvé"));
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


    public boolean checkOpened(Restaurant restaurant, Horaires horaires) {
        for (int i = 0; i < restaurant.getHoraires().size(); i++) {
            if (restaurant.getHoraires().get(i).getHoraire().equals(horaires.getHoraire())) {
                return true;
            }
        }
        return false;
    }

    public List<Object> addHoraire(long id_Horaire, long id_Restaurant) {
        Restaurant restaurant = getRestaurant(id_Restaurant);
        Horaires horaires = horairesRepository.findHorairesById(id_Horaire);
        if (restaurant == null) {
            return Arrays.asList("Restaurant non trouvé", HttpStatus.NOT_FOUND);
        }
        if (horaires == null) {
            return Arrays.asList("Horaire non trouvée", HttpStatus.NOT_FOUND);
        }
        restaurant.getHoraires().add(horaires);
//        horaire.getRestaurants().add(restaurant);
        restaurantRepository.save(restaurant);
        horairesRepository.save(horaires);
        return Arrays.asList("Horaire ajoutée à : " + restaurant.getNom() + " " + "Heure : " + horaires.getHoraire(), HttpStatus.OK);
    }


}
