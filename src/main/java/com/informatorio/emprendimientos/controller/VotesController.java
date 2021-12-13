package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.entity.Votes;
import com.informatorio.emprendimientos.repository.VotesRepository;
import com.informatorio.emprendimientos.service.VotesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votes")
public class VotesController {

    @Autowired
    VotesService votesService;
    @Autowired
    VotesRepository votesRepository;

    @PostMapping
    public Votes voto(@RequestBody Votes voto){
        return this.votesService.votar(voto);
    }

    @GetMapping 
    public ResponseEntity<?> votosPorUsuario(@RequestParam(required = false) String email){
        return new ResponseEntity<>(votesRepository.getByEmail(email), HttpStatus.OK);
    }
}
