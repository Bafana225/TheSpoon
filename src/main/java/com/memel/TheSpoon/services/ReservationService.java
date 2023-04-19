package com.memel.TheSpoon.services;

import com.memel.TheSpoon.DTO.ReservationDTO;
import com.memel.TheSpoon.entities.Horaires;
import com.memel.TheSpoon.entities.Reservation;
import com.memel.TheSpoon.entities.Restaurant;
import com.memel.TheSpoon.repository.HorairesRepository;
import com.memel.TheSpoon.repository.ReservationRepository;
import com.memel.TheSpoon.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;
@Service
public class ReservationService {


    private final ReservationRepository reservationRepository;
    private final RestaurantRepository restaurantRepository;
    private final HorairesRepository horaireRepository;

    public ReservationService(ReservationRepository reservationRepository,RestaurantRepository restaurantRepository,HorairesRepository horaireRepository) {
        this.reservationRepository = reservationRepository;
        this.restaurantRepository = restaurantRepository;
        this.horaireRepository = horaireRepository;
    }

    /**
     * Retourne une liste de réservations
     * @return List<Reservation> List<obj>
     */
    public List<Reservation> listResa() {
        return this.reservationRepository.findAll();
    }


    /**
     * Supprime une réservation par son id
     * @param id
     */
    public void supResaById(Long id) {
        if(reservationRepository.existsById(id)){
            this.reservationRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Réservation non trouvée");
        }
    }

    /**
     * Retourne une liste de réservations filtrée par le nom du restaurant
     * @param nom
     * @return List<Reservation> List<obj>
     */
    public List<Reservation> getResaByNomResto(String nom) {
        List<Reservation> listResaIn = this.reservationRepository.findAll();
        List<Reservation> listResaOut = this.findResaByNameResto(listResaIn, nom);
        if(listResaOut.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune réservation avec ce nom de restaurant");
        }
        return listResaOut;
    }


    /**
     * Retourne une liste de réservations filtrée par le nom du restaurant
     * @param listResa
     * @param nom
     * @return List<Reservation> List<obj>
     */
    private List<Reservation> findResaByNameResto(List<Reservation> listResa, String nom) {
        List<Reservation> result = new ArrayList<>();
        listResa.forEach(resa ->{
            if (resa.getRestaurant().getNom().equals(nom)){
                result.add(resa);
            }
        });
        return result;
    }


    /**
     * Cré ou modifie une réservation
     * @param resa <obj>
     * @return Reservation <obj>
     */
    public Reservation setResa(ReservationDTO resa) {
        // Vérifie si l'id resto est valide
        if(!this.restaurantRepository.existsById(resa.getRestaurant())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant inexistant");
        }
        // Instancie le Restaurant
        Restaurant resto = this.restaurantRepository.findById(resa.getRestaurant()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant non trouvé"));

        // Vérifie si l'id horaire est valide
        if(!this.horaireRepository.existsById(resa.getHoraire())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Horaire inexistant");
        }
        // Instancie l'horaire
        Horaires horaire = this.horaireRepository.findById(resa.getHoraire()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Horaire non trouvé"));

        // Vérifie si le restaurant est ouvert sur l'horaire demandé
        if(this.checkOpened(resto, horaire)){
            // Récupère la liste des réservations pour ce restaurant tout horaire confondu
            List<Reservation> resaByResto = resto.getReservations();
            List<Reservation> resaByHoraire = new ArrayList<>();
            // Si présence de réservations, on récupère les réservations sur l'horaire donnée
            if(!resaByResto.isEmpty()){
                resaByHoraire = this.getReservationByHoraire(resaByResto, horaire);
            }
            Integer nbrResa = 0;
            // Si présence de réservations sur cet horaire on compte celles-ci
            if (!resaByHoraire.isEmpty()){
                nbrResa = sommePersonnesByReservations(resaByHoraire);
            }
            // Vérifie si assez de place pour enregistrer cette réservation
            Integer somme = resa.getNbrAdulte()+resa.getNbrEnfant()+nbrResa;
            if(resto.getNbrplace() >= somme){
                Reservation resaFinal = new Reservation(resa.getId(), resa.getNbrAdulte(), resa.getNbrEnfant(), horaire, resto);
                return this.reservationRepository.save(resaFinal);
            }else{
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Il n'y a plus assez de place sur cette plage horaire");
            }

        }else{
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Le restaurant est fermé sur cette plage horaire");
        }
    }

    /**
     * Retourne la somme des places réservées
     * @param resaByHoraire
     * @return Integer
     */
    public Integer sommePersonnesByReservations(List<Reservation> resaByHoraire) {
        int result = 0;
        for(Reservation resa : resaByHoraire){
            result = result + resa.getNbrAdulte() + resa.getNbrEnfant();
        }
        return result;
    }

    /**
     * Retourne true si un restaurant est ouvert à l'horaire demandé
     * @param resto
     * @param horaire
     * @return Boolean
     */
    public boolean checkOpened(Restaurant resto, Horaires horaire) {
        boolean result = false;
        // Récupère la liste des horaires d'ouvertures du restaurant
        List<Horaires> horaireOuverture = resto.getHoraires();
        // Parcoure la liste des horaires d'ouverture et renvoie true si vérifié
        for(Horaires hor : horaireOuverture){
            if(hor.getId() == horaire.getId()){
                result = true;
                break;
            }else{
                result = false;
            }
        }
        return result;
    }

    /**
     * Retourne une liste de réservation à partir de l'id du restaurant
     * @param idResto
     * @return List<Reservation> List<obj>
     */
    public List<Reservation> getReservationsByIdResto(Long idResto){
        Restaurant Resto = this.restaurantRepository.findById(idResto).orElse(new Restaurant());
        if (Resto.getReservations().isEmpty()){
            return new ArrayList<>();
        }else{
            return Resto.getReservations();
        }
    }

    /**
     * Retourne une liste de réservations à partir d'une liste de réservations et un horaire donné
     * @param listResa
     * @param horaire
     * @return List<Reservation> List<obj>
     */
    public List<Reservation> getReservationByHoraire(List<Reservation> listResa, Horaires horaire){
        List<Reservation> result = new ArrayList<>();
        // Parcoure les réservations et si les créneaux horaires sont égaux
        // on ajoute la réservation au résultat demandé
        listResa.forEach(resa->{
            if(resa.getHoraires().getHoraire().equals(horaire.getHoraire())){
                result.add(resa);
            }
        });
        return result;
    }

}

