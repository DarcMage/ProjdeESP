package com.iesrfa.curso.clase05.controllers.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class UsuarioDto {
    private UUID id;
    private String user;

    private boolean rescribirclave=false;

}
