package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Horaires;

import java.util.List;

public interface HorairesService {
    Horaires saveHoraires(Horaires h);
    Horaires updateHoraires(Horaires h);
    void deleteHoraires(Horaires h);
    void deleteHorairesById(Long id);
    Horaires getHoraires(Long id);
    List<Horaires> getAllHoraires();
}
