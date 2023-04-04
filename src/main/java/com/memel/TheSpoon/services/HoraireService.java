package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Horaire;

import java.util.List;

public interface HoraireService {
    Horaire saveHoraire(Horaire h);
    Horaire updateHoraire(Horaire h);
    void deleteHoraire(Horaire h);
    void deleteHoraireById(Long id);
    Horaire getHoraire(Long id);
    List<Horaire> getAllHoraires();

}