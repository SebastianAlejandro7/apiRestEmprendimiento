package com.informatorio.emprendimientos.repository;

import java.util.List;

import com.informatorio.emprendimientos.entity.Votes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotesRepository extends JpaRepository<Votes, Long>{

    List<Votes> getByEmail(String email);
    
}
