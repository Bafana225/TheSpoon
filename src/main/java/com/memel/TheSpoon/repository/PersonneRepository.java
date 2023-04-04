package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

    Personne findPersonneById(Long id);

    void deletePersonneById(Long id);

    List<Personne> findByTypePersonneId(Long typePersonneId);

    @Query("SELECT p FROM Personne p WHERE p.typePersonne.libelle = :nom")
    List<Personne> findByTypePersonneNom(@Param("nom") String nom);

}