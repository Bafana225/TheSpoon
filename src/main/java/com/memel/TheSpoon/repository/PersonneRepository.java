package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource(path = "rest")
public interface PersonneRepository extends JpaRepository<Personne, Long> {
    Personne findPersonneById(Long id);
    void deletePersonById(Long id);

    List<Personne> findByTypePersonId(Long typePersonId);

}