package com.memel.TheSpoon.services;

import com.memel.TheSpoon.entities.Personne;
import java.util.List;

public interface PersonneService {

    Personne savePersonne(Personne p);
    Personne updatePersonne(Personne p);
    void deletePersonne(Personne p);
    void deletePersonneById(Long id);
    Personne getPersonne(Long id);

    List<Personne> getAllPersonnes();

}
