package com.iesrfa.curso.clase05.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbProductos")
public class ProductosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idproducto", nullable = false)
    private UUID id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "fechaVencimiento", nullable = false)
    private Date fechaVencimiento;
    @Column(name = "precioventa", nullable = false)
    private Double precioventa;
    @Column(name = "precioCompra", nullable = false)
    private Double precioCompra;
    @Column(name = "Stock", nullable = false)
    private Double stock;
    @Column(name = "StockMinimo", nullable = false)
    private Double stockMinimo;
}