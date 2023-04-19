package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
