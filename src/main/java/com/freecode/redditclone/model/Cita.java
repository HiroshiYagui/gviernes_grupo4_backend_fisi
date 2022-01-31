package com.freecode.redditclone.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Date;
import java.sql.Time;


import java.sql.Date;
import java.sql.Time;
import java.time.Instant;


import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import static javax.persistence.GenerationType.IDENTITY;;

@Data
@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long citaId;
    private Date fecha;
    private String especialidad;
    private Time hora;
    private boolean disponible;
    
}


