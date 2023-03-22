package com.iesrfa.curso.clase05.controllers;

import com.iesrfa.curso.clase05.controllers.dto.PersonaDto;
import com.iesrfa.curso.clase05.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/persona")
public class PersonaController {
    @Autowired
    PersonaService servicio;

    @GetMapping()
    public ResponseEntity<List<PersonaDto>> getAll(){
        try{
            return  new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<PersonaDto> save(@RequestBody PersonaDto dto){
        try{
            return  new ResponseEntity<>(servicio.savePersona(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<PersonaDto> update(@RequestBody PersonaDto dto){
        try{
            return  new ResponseEntity<>(servicio.savePersona(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deletePersona(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
