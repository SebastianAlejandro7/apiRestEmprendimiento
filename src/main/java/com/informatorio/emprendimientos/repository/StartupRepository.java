package com.informatorio.emprendimientos.repository;

import java.util.ArrayList;
import java.util.List;

import com.informatorio.emprendimientos.entity.Startup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StartupRepository extends JpaRepository<Startup, Long>{

    ArrayList<Startup> getByNombre(String nombre);
    @Query("SELECT e FROM Startup e join fetch e.tags t WHERE t.tagName LIKE %:tag%")
    List<Startup> findByTag(@Param("tag") String tag);
    List<Startup> findByPublicado(Boolean publicado);
    public List<Startup> findByOrderByVotosDesc();
    List<Startup> findByEventIdOrderByVotosDesc(Long eventId);

}
