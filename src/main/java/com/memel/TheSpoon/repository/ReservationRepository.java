package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public Optional<List<Reservation>> findByRestaurant(Restaurant restaurant);

    void deleteReservationById(Long id);
}