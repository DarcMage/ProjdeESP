package com.iesrfa.curso.clase05.services.repository;
import com.iesrfa.curso.clase05.models.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, UUID>{
    //List<UsuariosEntity> findByPersonaIdpersona(UUID idpersona);
}