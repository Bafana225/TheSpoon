package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Horaires;
import com.memel.TheSpoon.repository.HorairesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HorairesServiceImpl implements HorairesService {
    @Autowired
    HorairesRepository horairesRepository;
    @Override
    public Horaires saveHoraires(Horaires h) {
        return horairesRepository.save(h);
    }
    @Override
    public Horaires updateHoraires(Horaires h) {
        return horairesRepository.save(h);
    }
    @Override
    public void deleteHoraires(Horaires h) {
        horairesRepository.delete(h);
    }
    @Override
    public void deleteHorairesById(Long id) {
        horairesRepository.deleteById(id);
    }
    @Override
    public Horaires getHoraires(Long id) {
        return horairesRepository.findById(id).get();
    }
    @Override
    public List<Horaires> getAllHoraires() {
        return horairesRepository.findAll();
    }
}
