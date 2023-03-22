package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosEntity, UUID> {
    List<ProductosEntity> findByNombre(String nombre);
}