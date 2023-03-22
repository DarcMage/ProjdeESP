package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.PersonaDto;
import com.iesrfa.curso.clase05.models.PersonaEntity;
import com.iesrfa.curso.clase05.services.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonaService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PersonaRepository repository;

    public List<PersonaDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x,PersonaDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }

    public PersonaDto getPersona(String nombre, String apellidos){
        try{
            return this.modelMapper.map(
                    repository.findByNombreOrApellidos(nombre,apellidos),
                    PersonaDto.class);
        }catch(Exception ex){
            return null;
        }
    }

    public PersonaDto savePersona(PersonaDto registro){
        try{
            return  this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, PersonaEntity.class)
                    ),PersonaDto.class);
        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deletePersona(UUID id){
        try{
            Optional<PersonaEntity> registro=
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
