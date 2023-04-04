package com.memel.TheSpoon.RESTController;

import com.memel.TheSpoon.entities.Personne;
import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.services.PersonneService;
import com.memel.TheSpoon.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations-api")
@CrossOrigin
public class ReservationRESTController {
    @Autowired
    ReservationService reservationService;

    @Autowired
    private PersonneService personneService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reservation> getAllReservations()
    {
        return reservationService.getAllReservations();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Reservation getReservationById(@PathVariable("id") Long id) {
        return reservationService.getReservation(id);
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @RequestMapping(value="/personne/{id}", method = RequestMethod.GET)
    public Long getPersonneIdByReservationId(@PathVariable("id") Long id) {
        Reservation reservation = reservationService.getReservation(id);
        Personne personne = reservation.getPersonne();
        return personne.getId();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteReservation(@PathVariable("id") Long id)
    {
        reservationService.deleteReservationById(id);
    }

}