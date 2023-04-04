package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

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
}
