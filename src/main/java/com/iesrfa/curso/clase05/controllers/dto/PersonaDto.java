package com.iesrfa.curso.clase05.controllers.dto;

import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
public class PersonaDto {

    private UUID id=null;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private Double peso=50.0;
    private Double talla=1.50;
    private Date fechanacimiento=new Date();

}
