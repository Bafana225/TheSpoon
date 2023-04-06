package com.memel.TheSpoon;

import com.memel.TheSpoon.entities.Horaires;
import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TheSpoonApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private RestaurantServiceImpl restaurantsService;

	@Autowired
	private ReservationServiceImpl reservationService;

	@Autowired
	private HorairesServiceImpl horairesService;


	@Test
	public void testCheckOpen(){
		//Ajout d'horaire
		Horaires horaires1 = new Horaires();
		horaires1.setId(1L);
		horaires1.setHoraire("01h - 02h");
		horairesService.addHoraire(horaires1);

		Horaires horaires2 = new Horaires();
		horaires2.setId(2L);
		horaires2.setHoraire("04h - 05h");
		horairesService.addHoraire(horaires2);

		//Ajout de restaurants
		Restaurant restaurants1 = new Restaurant();
		restaurants1.setId(1L);
		restaurants1.setAdresse("Dinan");
		restaurants1.setNom("Pizza");
		restaurants1.setNbCouverts(10);
		restaurants1.setPrixMoyen(15.0);
		restaurants1.setAccessibilitePmr(true);
		restaurantsService.addRestaurant(restaurants1);

		Restaurant restaurants2 = new Restaurant();
		restaurants2.setId(2L);
		restaurants2.setAdresse("Rennes");
		restaurants2.setNom("Burger");
		restaurants2.setNbCouverts(5);
		restaurants2.setPrixMoyen(10.0);
		restaurants2.setAccessibilitePmr(false);
		restaurantsService.addRestaurant(restaurants2);

		//Ajout horaire au restos
		restaurantsService.addHoraire(1L, 1L);
		restaurantsService.addHoraire(2L, 2L);

		restaurants1 = restaurantsService.getRestaurant(1L);
		restaurants2 = restaurantsService.getRestaurant(2L);

		//Le cas ou le restaurant n'est pas ouvert
		Restaurant restaurant = restaurantsService.getRestaurant(1L);
		boolean result = reservationService.checkOpen(restaurant, horaires2);
		assertFalse(result);

		//Le Cas ou le restaurant est ouvert
		Restaurant restaurant2 = restaurantsService.getRestaurant(2L);
		boolean result2 = reservationService.checkOpen(restaurant2, horaires2);
		assertTrue(result2);
	}


}
