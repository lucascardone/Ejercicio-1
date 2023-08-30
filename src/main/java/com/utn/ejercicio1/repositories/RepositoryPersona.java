package com.utn.ejercicio1.repositories;

import com.utn.ejercicio1.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPersona extends JpaRepository<Persona, Long> {
}
