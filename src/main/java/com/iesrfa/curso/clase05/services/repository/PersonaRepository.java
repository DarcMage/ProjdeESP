package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, UUID> {
    PersonaEntity findByNombreOrApellidos(String nombre,String apellidos);
}
