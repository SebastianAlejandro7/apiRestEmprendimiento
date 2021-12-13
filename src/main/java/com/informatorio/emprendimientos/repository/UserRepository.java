package com.informatorio.emprendimientos.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.informatorio.emprendimientos.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    public List<User> findByCiudad(String ciudad);
    public List<User> findByFechaCreacionAfter(LocalDateTime localDateTime);
    
}

