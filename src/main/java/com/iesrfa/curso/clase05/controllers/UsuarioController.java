package com.iesrfa.curso.clase05.controllers;

import com.iesrfa.curso.clase05.controllers.dto.UsuarioDto;
import com.iesrfa.curso.clase05.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/usuarios")
public class UsuarioController {
    //localhost:8080/v1/usuarios/
    //127.0.0.1:8888/v1/usuarios/
    //miempresa.com:8081/v1/usuarios/

    @Autowired
    UsuarioService servicio;

    @GetMapping()
    public ResponseEntity<List<UsuarioDto>> getAll(){
        try{
            return  new ResponseEntity<>(servicio.getAll(),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //localhost:8080/v1/usuarios/idusuario
    //localhost:8080/v1/usuarios/1
    @GetMapping("{idPersona}")
    public ResponseEntity<List<UsuarioDto>> get(@PathVariable("idPersona") UUID idPersona ){
        try{
           return new ResponseEntity<>(
                   servicio.getUsuario(idPersona),
                   HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<UsuarioDto> save(UsuarioDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveUsuario(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<UsuarioDto> update(@RequestBody UsuarioDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveUsuario(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        try{
            return  new ResponseEntity<>(servicio.deleteUsuario(id),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //@GetMapping   -> Leer
    //@PostMapping  -> Guardar/Crear
    //@PutMapping   -> Actualizar
    //@PatchMapping -> Actualizar/ parte del objecto -> parchar
    //@DeleteMapping-> Eliminar
}
