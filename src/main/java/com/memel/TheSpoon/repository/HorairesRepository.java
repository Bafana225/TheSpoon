package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Horaires;
import org.springframework.data.jpa.repository.JpaRepository;



public interface HorairesRepository extends JpaRepository<Horaires, Long> {
    //Trouver les horaires a partir d'un id
    Horaires findHorairesById(Long id);

    //Supprimer les horaires a partir de l'id
    void deleteHorairesById(Long id);

}

