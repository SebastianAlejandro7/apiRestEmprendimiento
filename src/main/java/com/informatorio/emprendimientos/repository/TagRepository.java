package com.informatorio.emprendimientos.repository;

import com.informatorio.emprendimientos.entity.Tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tags, Long>{
   
}
