package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.ProductoDto;
import com.iesrfa.curso.clase05.models.ProductosEntity;

import com.iesrfa.curso.clase05.services.repository.ProductosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductosService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProductosRepository repository;

    public List<ProductoDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x,ProductoDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }

    public List<ProductoDto> getProducto(String nombre){
        try{
            return repository.findByNombre(nombre)
                    .stream()
                    .map(x->modelMapper.map(x, ProductoDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }

    public ProductoDto saveProducto(ProductoDto registro){
        try{
            return  this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, ProductosEntity.class)
                    ),ProductoDto.class);
        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteProducto(UUID id){
        try{
            Optional<ProductosEntity> registro=
                    repository.findById(id);
            if(registro.isPresent()){
                repository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return false;
        }
    }
}
