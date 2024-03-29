package com.memel.TheSpoon.RESTController;

import com.memel.TheSpoon.DTO.ReservationDTO;
import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.services.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api-reservation")
@Validated
public class ReservationRESTController {
    private final ReservationService reservationService;
    public ReservationRESTController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("get/{id}")
    @Operation(summary = "Récupère une réservation", description = "Récupère une réservation à partir de son id")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") @Positive Long id) {
        List<Reservation> reservations = this.reservationService.getReservationsByIdResto(id);
        if (reservations.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation non trouvée");
        }
        Reservation reservation = reservations.get(0);
        return ResponseEntity.ok().body(reservation);
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
    @Operation(summary = "Crée une réservation", description = "Cré une réservation à partir des id Horaire et Restaurant")
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

    @GetMapping("/{idResto}/reservations")
    @Operation(summary = "Liste les réservations d'un restaurant", description = "Liste toutes les réservations d'un restaurant")
    public ResponseEntity<List<Reservation>> getReservationsByRestoId(@PathVariable("idResto") Long idResto) {
        List<Reservation> reservations = reservationService.getReservationsByIdResto(idResto);
        if (reservations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        }
    }

}