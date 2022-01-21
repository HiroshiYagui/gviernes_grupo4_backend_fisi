package com.freecode.redditclone.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotBlank;

import java.time.Instant;
import java.sql.Date;
import java.sql.Time;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long cita_id;
    private Date fecha;
    private String especialidad;
    private Time hora;
    private boolean disponible;
    
}


