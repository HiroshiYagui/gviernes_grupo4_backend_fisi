package com.clinica.clinicaapp.model;

import java.sql.Timestamp;
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

import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;;

@Data
@Entity
public class Historial {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long historialId;
    
    private Timestamp fecha_creacion;

    @OneToOne(fetch=LAZY)
    @JoinColumn(name="usuarioId",referencedColumnName="usuarioId")
    private Usuario usuario;
}
