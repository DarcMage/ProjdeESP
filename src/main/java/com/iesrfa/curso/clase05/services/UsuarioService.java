package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.UsuarioDto;
import com.iesrfa.curso.clase05.models.UsuariosEntity;
import com.iesrfa.curso.clase05.services.repository.UsuariosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UsuariosRepository usuariosRepository;

    public List<UsuarioDto> getAll(){
        try{
            return usuariosRepository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x,UsuarioDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
           return null;
        }
    }

    public List<UsuarioDto> getUsuario(UUID idPersona){
        try{
            /*return usuariosRepository.findByPersonaIdpersona(idPersona)
                    .stream()
                    .map(x->modelMapper.map(x,UsuarioDto.class))
                    .collect(Collectors.toList());*/
            return null;
        }catch(Exception ex){
            return null;
        }
    }

    public UsuarioDto saveUsuario(UsuarioDto user){
        try{
            return  this.modelMapper.map(
                    usuariosRepository.save(
                    this.modelMapper.map(user,UsuariosEntity.class)
            ),UsuarioDto.class);
        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteUsuario(UUID idUsuario){
        try{
            Optional<UsuariosEntity> user=
                    usuariosRepository.findById(idUsuario);
            if(user.isPresent()){
                usuariosRepository.delete(user.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return false;
        }
    }


}
