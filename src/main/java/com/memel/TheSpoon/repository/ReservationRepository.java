package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "rest")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findReservationById(Long id);

    void deleteReservationById(Long id);
}