package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.entity.Event;
import com.informatorio.emprendimientos.repository.EventRepository;
import com.informatorio.emprendimientos.repository.StartupRepository;
import com.informatorio.emprendimientos.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {
    
    @Autowired
    EventService eventService;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    StartupRepository startupRepository;

    @PostMapping
    public Event guardarEvent(@RequestBody Event event){
        return this.eventService.obtenerEvent(event);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.eventService.eliminarEvent(id);
        if (ok){
            return "Se eliminó el evento con id " + id;
        }else{
            return "No pudo eliminar el evento con id" + id;
        }
    }

    @PutMapping("/{id}")
    public Event actualizarEvent(@PathVariable("id") Long id, @RequestBody Event event){
        return this.eventService.actualizarEvent(id, event);
    }

    @GetMapping
    public ResponseEntity<?> ranking(@RequestParam(required = false) Long eventId){
        return new ResponseEntity<>(startupRepository.findByEventIdOrderByVotosDesc(eventId), HttpStatus.OK);
    }

}
