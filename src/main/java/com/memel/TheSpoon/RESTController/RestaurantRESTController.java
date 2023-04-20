package com.memel.TheSpoon.RESTController;

import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.services.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants-api")
@CrossOrigin
public class RestaurantRESTController {
    private final RestaurantService restaurantService;
    public RestaurantRESTController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    /**
     * Liste tous les restaurants
     * @return List<Restaurant> List<obj>
     */
    @GetMapping("/lister")
    @Operation(summary = "Liste les restaurants", description = "Liste les restaurants sans filtre")
    public ResponseEntity<List<Restaurant>> listResto(){
        return new ResponseEntity<>(this.restaurantService.listResto(), HttpStatus.OK);
    }

    /**
     * Cré un restaurant
     * @param Resto <obj>
     * @return Restaurant <obj>
     */
    @PostMapping("/ajouter")
    @Operation(summary = "Cré un restaurant", description = "Cré un restaurant à partir de son model")
    public ResponseEntity<Restaurant> ajouterResto(@Valid @RequestBody Restaurant Resto){
        return new ResponseEntity<>(this.restaurantService.ajoutResto(Resto),HttpStatus.OK);
    }

    /**
     * Modifie un restaurant
     * @param Resto
     * @return Restaurant <obj>
     */
    @PostMapping("/editer")
    @Operation(summary = "Modifie un restaurant", description = "Modifie un restaurant à partir de son model")
    public ResponseEntity<Restaurant> editerResto(@Valid @RequestBody Restaurant Resto){
        return new ResponseEntity<>(this.restaurantService.editResto(Resto), HttpStatus.OK);
    }

    /**
     * Supprime un restaurant
     * @param id
     * @return HttpStatus.OK
     */
    @DeleteMapping("/supprimer/{id}")
    @Operation(summary = "Supprime un restaurant", description = "Supprime un restaurant à partir de son id")
    public ResponseEntity supResto(@PathVariable("id") @Positive Long id){
        this.restaurantService.supRestoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
