package com.informatorio.emprendimientos.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="votes")
public class Votes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long startupId;
    private Long eventId;
    private String email;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;
    
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getStartupId() {
        return startupId;
    }
    public void setStartupId(Long startupId) {
        this.startupId = startupId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    @Override
    public String toString() {
        return "Votes [email=" + email + ", eventId=" + eventId + ", fechaCreacion=" + fechaCreacion + ", id=" + id
                + ", startupId=" + startupId + "]";
    }

    
    
    
}
