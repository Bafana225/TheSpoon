package com.memel.TheSpoon;

//import com.memel.TheSpoon.entities.Horaires;
//import com.memel.TheSpoon.entities.Reservation;
//import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TheSpoonApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private HorairesService horairesService;


//	@Test
//	public void testCheckOpened(){
//		//Ajout d'horaire
//		Horaires horaires1 = new Horaires();
//		horaires1.setId(1L);
//		horaires1.setHoraire("04h - 11h");
//		horairesService.addHoraire(horaires1);
//
//		Horaires horaires2 = new Horaires();
//		horaires2.setId(2L);
//		horaires2.setHoraire("14h - 15h");
//		horairesService.addHoraire(horaires2);
//
//		//Ajout restaurants
//		Restaurant restaurants1 = new Restaurant();
//		restaurants1.setId(1L);
//		restaurants1.setAdresse("Plougastel");
//		restaurants1.setNom("Creperie");
//		restaurants1.setNbCouverts(10);
//		restaurants1.setPrixMoyen(15.0);
//		restaurants1.setAccessibilitePmr(true);
//		restaurantService.addRestaurant(restaurants1);
//
//		Restaurant restaurants2 = new Restaurant();
//		restaurants2.setId(2L);
//		restaurants2.setAdresse("Paris");
//		restaurants2.setNom("Barlou Burger");
//		restaurants2.setNbCouverts(5);
//		restaurants2.setPrixMoyen(10.0);
//		restaurants2.setAccessibilitePmr(false);
//		restaurantService.addRestaurant(restaurants2);
//
//		//Ajout horaire aux restos
//		restaurantService.addHoraire(1L, 1L);
//		restaurantService.addHoraire(2L, 2L);
//
//		restaurants1 = restaurantService.getRestaurant(1L);
//		restaurants2 = restaurantService.getRestaurant(2L);
//
//		//Cas ou le restaurant n'est pas ouvert
//		Restaurant restaurant = restaurantService.getRestaurant(1L);
//		boolean result = restaurantService.checkOpened(restaurant, horaires2);
//		assertFalse(result);
//
//		//Cas ou le restaurant est ouvert
//		Restaurant restaurant2 = restaurantService.getRestaurant(2L);
//		boolean result2 = restaurantService.checkOpened(restaurant2, horaires2);
//		assertTrue(result2);
//	}
//
//	@Test
//	public void testGetReservationsByNomRestaurant() {
//
//		Restaurant restaurant1 = new Restaurant();
//		restaurant1.setId(1L);
//		restaurant1.setNom("Au Vieux port");
//		restaurant1.setAdresse("47 rue de la madelaine");
//		restaurant1.setNbCouverts(120);
//		restaurant1.setAccessibilitePmr(true);
//		restaurant1.setPrixMoyen(15.3);
//
//		Restaurant restaurant2 = new Restaurant();
//		restaurant2.setId(2L);
//		restaurant2.setNom("Au fourneau");
//		restaurant2.setAdresse("58 rue du port");
//		restaurant2.setNbCouverts(15);
//		restaurant2.setAccessibilitePmr(false);
//		restaurant2.setPrixMoyen(15.6);
//
//		restaurantService.addRestaurant(restaurant1);
//		restaurantService.addRestaurant(restaurant2);
//
//
//		/** Horaires **/
//		Horaires horaire1 = new Horaires();
//		horaire1.setId(1L);
//		horaire1.setHoraire("12h-13h");
//
//		Horaires horaire2 = new Horaires();
//		horaire2.setId(2L);
//		horaire2.setHoraire("13h-14h");
//
//		horairesService.addHoraire(horaire1);
//		horairesService.addHoraire(horaire2);
//
//
//		/** On ajoute les horaires aux restaurants **/
//		restaurantService.addHoraire(1L, 1L);
//		restaurantService.addHoraire(2L, 2L);
//
//
//		/** On ajoute les réservations **/
//		Reservation reservations1 = new Reservation();
//		reservations1.setId(1L);
//		reservations1.setHoraires(horaire1);
//		reservations1.setNbAdultes(4);
//		reservations1.setNbEnfants(2);
//		reservations1.setRestaurant(restaurant1);
//
//		Reservation reservation2 = new Reservation();
//		reservation2.setId(2L);
//		reservation2.setHoraires(horaire2);
//		reservation2.setNbAdultes(2);
//		reservation2.setNbEnfants(2);
//		reservation2.setRestaurant(restaurant2);
//
//		reservationService.addReservation(reservations1);
//		reservationService.addReservation(reservation2);
//
//
//		/** Obtenir les réservations pour le restaurant "Au Délice de Rennes" **/
//		List<Object> result = reservationService.getReservationByNomRestaurant("Au Délice de Rennes");
//		List<Reservation> reservations = (List<Reservation>) result.get(0);
//
//		assertEquals(1, reservations.size());
//		assertEquals(reservations1.getId(), reservations.get(0).getId());
//
//	}

}
