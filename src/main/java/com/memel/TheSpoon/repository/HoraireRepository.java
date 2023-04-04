package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Horaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "rest")
public interface HoraireRepository extends JpaRepository<Horaire, Long> {
    Horaire findHoraireById(Long id);

    void deleteHoraireById(Long id);
}
