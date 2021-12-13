package com.informatorio.emprendimientos.controller;

import java.time.LocalDate;
import java.util.Optional;

import com.informatorio.emprendimientos.entity.User;
import com.informatorio.emprendimientos.repository.UserRepository;
import com.informatorio.emprendimientos.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    

    @PostMapping
    public User guardarUsuario(@RequestBody User usuario){
        return this.userService.guardarUsuario(usuario);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.userService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<User> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.userService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public User actualizarUser(@PathVariable Long id, @RequestBody User user){
        return this.userService.actualizarUser(id, user);
    }

    @GetMapping 
    public ResponseEntity<?> obtenerUser(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @RequestParam(required = false) String ciudad){
                if(fecha != null){
                    return new ResponseEntity<>(userRepository.findByFechaCreacionAfter(fecha.atStartOfDay()), HttpStatus.OK);
                } else if (ciudad != null){
                    return new ResponseEntity<>(userRepository.findByCiudad(ciudad), HttpStatus.OK);
                }
                return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}
