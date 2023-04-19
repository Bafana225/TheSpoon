package com.memel.TheSpoon.DTO;

public class ReservationDTO {

    private Long id;
    private Integer nbrAdulte;
    private Integer nbrEnfant;
    private Long horaire;
    private Long restaurant;

    public ReservationDTO(Long id, Integer nbrAdulte, Integer nbrEnfant, Long horaire, Long restaurant) {
        this.id = id;
        this.nbrAdulte = nbrAdulte;
        this.nbrEnfant = nbrEnfant;
        this.horaire = horaire;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }
    public Integer getNbrAdulte() {
        return nbrAdulte;
    }
    public Integer getNbrEnfant() {
        return nbrEnfant;
    }
    public Long getHoraire() {
        return horaire;
    }
    public Long getRestaurant() {
        return restaurant;
    }
}
