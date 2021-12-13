package com.informatorio.emprendimientos.service;

import java.util.ArrayList;
import java.util.Optional;

import com.informatorio.emprendimientos.entity.User;
import com.informatorio.emprendimientos.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public ArrayList<User> obtenerUsuarios(){
        return (ArrayList<User>) userRepository.findAll();
    } 

    public Optional<User> obtenerPorId(Long id){
        return userRepository.findById(id);
    }

    public User guardarUsuario(User usuario){
        return userRepository.save(usuario);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public User actualizarUser(Long userId, User userNew){
        User userOld = userRepository.getById(userId);
        if(userNew.getNombre() != null){
            userOld.setNombre(userNew.getNombre());
        }
        if(userNew.getApellido() != null){
            userOld.setApellido(userNew.getApellido());
        }
        if(userNew.getPais() != null){
            userOld.setPais(userNew.getPais());
        }
        if(userNew.getCiudad() != null){
            userOld.setCiudad(userNew.getCiudad());
        }
        if(userNew.getProvincia() != null){
            userOld.setProvincia(userNew.getProvincia());
        }
        return userRepository.save(userOld);
    }
}
