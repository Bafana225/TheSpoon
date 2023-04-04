package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Restaurant;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Entity
@RepositoryRestResource(path = "rest")
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findRestaurantById(Long id);

    void deleteRestaurantById(Long id);
}
