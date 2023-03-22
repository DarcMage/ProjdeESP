package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.MenuDto;
import com.iesrfa.curso.clase05.models.MenusEntity;
import com.iesrfa.curso.clase05.services.repository.MenusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MenusService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MenusRepository repository;

    public List<MenuDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x,MenuDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }

    public MenuDto getOrden(){
        try{
            /*return this.modelMapper.map(
                    repository.findByOrden(nombre,apellidos),
                    MenuDto.class);*/
            return null;
        }catch(Exception ex){
            return null;
        }
    }

    public MenuDto save(MenuDto registro){
        try{
            return  this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, MenusEntity.class)
                    ),MenuDto.class);
        }catch(Exception ex){
            return null;
        }
    }
    public Boolean delete(UUID id){
        try{
            Optional<MenusEntity> registro=
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
