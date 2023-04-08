package com.memel.TheSpoon.RESTController;

import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants-api")
@CrossOrigin
public class RestaurantRESTController {
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable("id") Long id) {
        return restaurantService.getRestaurant(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Restaurant updateProduit(@RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurantById(id);
    }

}
