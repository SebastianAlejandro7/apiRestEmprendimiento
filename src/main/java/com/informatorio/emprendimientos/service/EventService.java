package com.informatorio.emprendimientos.service;

import com.informatorio.emprendimientos.entity.Event;
import com.informatorio.emprendimientos.repository.EventRepository;
import com.informatorio.emprendimientos.repository.StartupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    StartupRepository startupRepository;

    public Event obtenerEvent(Event event){
        return eventRepository.save(event);
    }

    public boolean eliminarEvent(Long id) {
        try{
            eventRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public Event actualizarEvent(Long eventId, Event eventNew){
        Event eventOld = eventRepository.getById(eventId);
        if(eventNew.getDetalles() != null){
            eventOld.setDetalles(eventNew.getDetalles());
        }
        if(eventNew.getActivo() != null){
            eventOld.setActivo(eventNew.getActivo());
        }
        if(eventNew.getFechaCierre() != null){
            eventOld.setFechaCierre(eventNew.getFechaCierre());
        }
        if(eventNew.getEstado() != null){
            eventOld.setEstado(eventNew.getEstado());
        }
        if(eventNew.getPremio() != 0){
            eventOld.setPremio(eventNew.getPremio());
        }
        return eventRepository.save(eventOld);
    }
}
