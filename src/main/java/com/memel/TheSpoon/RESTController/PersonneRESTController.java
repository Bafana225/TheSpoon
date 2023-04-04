package com.memel.TheSpoon.RESTController;

import com.memel.TheSpoon.entities.Personne;
import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.services.PersonneServiceImpl;
import com.memel.TheSpoon.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes-api")
@CrossOrigin
public class PersonneRESTController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    private PersonneServiceImpl personneServiceImpl;


    @RequestMapping(value="/all",method = RequestMethod.GET)
    public List<Personne> getAllPersonnes()
    {
        return personneServiceImpl.getAllPersonnes();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Personne getPersonneById(@PathVariable("id") Long id) {
        return personneServiceImpl.getPersonne(id);
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Personne createPersonne(@RequestBody Personne personne) {
        return personneServiceImpl.savePersonne(personne);
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Personne updatePersonne(@RequestBody Personne personne) {
        return personneServiceImpl.updatePersonne(personne);
    }

    @RequestMapping(value="/reservations/{id}", method = RequestMethod.GET)
    public List<Reservation> getReservationsByPersonneId(@PathVariable("id") Long id) {
        Personne personne = personneServiceImpl.getPersonne(id);
        return personne.getReservations();
    }

    @RequestMapping(value="/add-command/{client_id}/{commande_id}", method=RequestMethod.PUT)
    public ResponseEntity<List<Reservation>> addCommandeClient(@PathVariable Long personne_id, @PathVariable Long reservation_id) {
        Personne personne = personneServiceImpl.addReservation(personne_id, reservation_id);
        List<Reservation> reservations = personne.getReservations();
        return ResponseEntity.ok(reservations);
    }


    @RequestMapping(value="/remove-reservation/{personne_id}/{reservation_id}",method = RequestMethod.DELETE)
    public ResponseEntity<Personne> removeReservationPersonne(@PathVariable Long personne_id, @PathVariable Long reservation_id){
        Personne newPersonne = personneServiceImpl.deleteReservation(personne_id, reservation_id);
        return new ResponseEntity<>(newPersonne, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public void deletePersonne(@PathVariable("id") Long id)
    {
        personneServiceImpl.deletePersonneById(id);
    }


}