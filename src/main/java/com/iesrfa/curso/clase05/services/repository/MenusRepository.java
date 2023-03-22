package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.MenusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenusRepository extends JpaRepository<MenusEntity, UUID>{
}