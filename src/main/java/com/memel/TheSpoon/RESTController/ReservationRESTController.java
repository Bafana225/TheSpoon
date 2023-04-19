package com.memel.TheSpoon.RESTController;

import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.services.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations-api")
@CrossOrigin
public class ReservationRESTController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Liste toutes les reservations
     * @return List<Reservation> List<obj>
     */
    @GetMapping("/lister")
    @Operation(summary = "Liste les réservations", description = "Liste des réservations sans filtre")
    public ResponseEntity<List<Reservation>> listResa(){
        return new ResponseEntity<>(this.reservationService.listResa(), HttpStatus.OK);
    }

    /**
     * Liste les réservations avec filtre sur le nom du restaurant
     * @param nom
     * @return List<Reservation>
     */
    @GetMapping("/ResaByResto/{nom}")
    @Operation(summary = "Liste les réservations avec filtre", description = "Liste les réservations avec filtre sur le nom du restaurant")
    public ResponseEntity<List<Reservation>> getResaByNomResto(@PathVariable String nom){
        return new ResponseEntity<>(this.reservationService.getResaByNomResto(nom), HttpStatus.OK);
    }


    /**
     * Cré une réservation à partir des id Horaire et Restaurant
     * @param resa <ReservationDTO>
     * @return Reservation <obj>
     */
    @PostMapping("/ajouter")
    @Operation(summary = "Cré une réservation", description = "Cré une réservation à partir des id Horaire et Restaurant")
    public ResponseEntity<Reservation> ajouterResa(@Valid @RequestBody ReservationDTO resa){
        Reservation retour = this.reservationService.setResa(resa);
        return new ResponseEntity<>(retour, HttpStatus.OK);
    }


    /**
     * Modifie une réservation à partir des id Horaire et Restaurant
     * @param resa <ReservationDTO>
     * @return Reservation <obj>
     */
    @PostMapping("/editer")
    @Operation(summary = "Modifie une réservation", description = "Modifie une réservation à partir des id Horaire et Restaurant")
    public ResponseEntity<Reservation> editResa(@Valid @RequestBody ReservationDTO resa){
        return new ResponseEntity<>(this.reservationService.setResa(resa), HttpStatus.OK);
    }


    /**
     * Supprime une réservation à partir de son id
     * @param id
     * @return HttpStatus.OK
     */
    @DeleteMapping("/supprimer/{id}")
    @Operation(summary = "Supprime une réservation", description = "Supprime une réservation à partir de son id")
    public ResponseEntity supResa(@PathVariable("id") @Positive Long id){
        this.reservationService.supResaById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}