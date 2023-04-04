package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Horaire;
import com.memel.TheSpoon.repository.HoraireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoraireServiceImpl implements HoraireService {
    @Autowired
    HoraireRepository horaireRepository;

    @Override
    public Horaire saveHoraire(Horaire h) {
        return horaireRepository.save(h);
    }

    @Override
    public Horaire updateHoraire(Horaire h) {
        return horaireRepository.save(h);
    }

    @Override
    public void deleteHoraire(Horaire h) {
        horaireRepository.delete(h);
    }

    @Override
    public void deleteHoraireById(Long id) {
        horaireRepository.deleteById(id);
    }

    @Override
    public Horaire getHoraire(Long id) {
        return horaireRepository.findById(id).get();
    }

    @Override
    public List<Horaire> getAllHoraires() {
        return horaireRepository.findAll();
    }
}
