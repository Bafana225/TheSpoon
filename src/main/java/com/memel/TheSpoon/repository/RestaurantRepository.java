package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findRestaurantById(Long id);

    void deleteRestaurantById(Long id);
}
