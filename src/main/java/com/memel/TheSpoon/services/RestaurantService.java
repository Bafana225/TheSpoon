package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant saveRestaurant(Restaurant r);

    Restaurant updateRestaurant(Restaurant r);

    void deleteRestaurant(Restaurant r);
    void deleteRestaurantById(Long id);
    Restaurant getRestaurant(Long id);
    List<Restaurant> getAllRestaurants();

}
