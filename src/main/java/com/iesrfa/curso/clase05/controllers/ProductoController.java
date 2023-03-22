package com.iesrfa.curso.clase05.controllers;


import com.iesrfa.curso.clase05.controllers.dto.ProductoDto;
import com.iesrfa.curso.clase05.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/producto")
public class ProductoController {
    @Autowired
    ProductosService servicio;

    @GetMapping()
    public ResponseEntity<List<ProductoDto>> getAll(){
        try{
            return  new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveProducto(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<ProductoDto> update(@RequestBody ProductoDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveProducto(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            return  new ResponseEntity<>(
                    Boolean.TRUE.equals(
                            servicio.deleteProducto(id))?
                            "Registro Eliminado Correctamente":
                            "Error al eliminar Registro",HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
