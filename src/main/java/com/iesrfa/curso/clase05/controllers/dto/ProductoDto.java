package com.iesrfa.curso.clase05.controllers.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ProductoDto {
    private UUID id=null;
    private String nombre;
    private Double precio;
    private Date fechaVencimiento=new Date();
    private Double precioventa;
    private Double precioCompra;
    private Double stock;
    private Double stockMinimo;
}
