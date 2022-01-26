package com.freecode.redditclone.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;
import static javax.persistence.GenerationType.IDENTITY;;

@Data
@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long cita_id;
    private Date fecha;
    private String especialidad;
    private Time hora;
    private boolean disponible;
    
}


