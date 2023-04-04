package com.memel.TheSpoon.repository;

import com.memel.TheSpoon.entities.Horaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "rest")
public interface HorairesRepository extends JpaRepository<Horaires, Long> {

    Horaires findHorairesById(Long id);

    void deleteHorairesById(Long id);

}
