package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.entity.Startup;
import com.informatorio.emprendimientos.repository.StartupRepository;
import com.informatorio.emprendimientos.repository.TagRepository;
import com.informatorio.emprendimientos.service.StartupService;
import com.informatorio.emprendimientos.service.TagService;

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
@RequestMapping("/startup")
public class StartupController {

    @Autowired
    StartupService startupService;
    @Autowired
    TagService tagService;
    @Autowired
    StartupRepository startupRepository;
    @Autowired
    TagRepository tagRepository;


    @PostMapping
    public Startup guardarStartup(@RequestBody Startup startup){
        return this.startupService.guardarStartup(startup);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.startupService.eliminarStartup(id);
        if (ok){
            return "Se eliminó la startup con id " + id;
        }else{
            return "No pudo eliminar la startup con id" + id;
        }
    }

    @PutMapping("/{id}")
    public Startup actualizarUser(@PathVariable Long id, @RequestBody Startup startup){
        return this.startupService.actualizarStartup(id, startup);
    }

    @GetMapping 
    public ResponseEntity<?> obtenerStartups(@RequestParam(required = false) Boolean o,
                                            @RequestParam(required = false) String tag){
        if(o != null){
            return new ResponseEntity<>(startupRepository.findByPublicado(o), HttpStatus.OK);
        }else if(tag != null){
            return new ResponseEntity<>(startupRepository.findByTag(tag), HttpStatus.OK);
        }
        return new ResponseEntity<>(startupRepository.findAll(), HttpStatus.OK);
    }
    
}
