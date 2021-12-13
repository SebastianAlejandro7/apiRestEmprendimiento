package com.informatorio.emprendimientos.service;

import java.util.ArrayList;
import java.util.Optional;

import com.informatorio.emprendimientos.entity.Startup;
import com.informatorio.emprendimientos.repository.StartupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartupService {
    
    @Autowired
    StartupRepository startupRepository;

    public ArrayList<Startup> obtenerStartup(){
        return (ArrayList<Startup>) startupRepository.findAll();
    } 

    public Optional<Startup> obtenerPorId(Long id){
        return startupRepository.findById(id);
    }

    public Startup guardarStartup(Startup Startup){
        return startupRepository.save(Startup);
    }

    public boolean eliminarStartup(Long id) {
        try{
            startupRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    public Startup actualizarStartup(Long startupId, Startup startupNew){
        Startup startupOld = startupRepository.getById(startupId);
        if(startupNew.getContenido() != null){
            startupOld.setContenido(startupNew.getContenido());
        }
        if(startupNew.getDescripcion() != null){
            startupOld.setDescripcion(startupNew.getDescripcion());
        }
        if(startupNew.getObjetivo() != 0){
            startupOld.setObjetivo(startupNew.getObjetivo());
        }
        if(startupNew.isPublicado()){
            startupOld.setPublicado(startupNew.isPublicado());
        }
        if(startupNew.getTags() != null){
            startupOld.setTags(startupNew.getTags());
        }
        if(startupNew.getEventId() != null){
            startupOld.setEventId(startupNew.getEventId());
        }
        return startupRepository.save(startupOld);
    }

    public ArrayList<Startup> obtenerPorNombre(String nombre){
        return startupRepository.getByNombre(nombre);
    }
}
