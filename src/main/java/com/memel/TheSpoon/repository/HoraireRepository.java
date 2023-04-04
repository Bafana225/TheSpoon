package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Horaire;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Entity
@RepositoryRestResource(path = "rest")
public interface HoraireRepository extends JpaRepository<Horaire, Long> {
    Horaire findHoraireById(Long id);

    void deleteHoraireById(Long id);
}
