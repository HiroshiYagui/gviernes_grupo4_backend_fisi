package com.freecode.redditclone.model;

import java.sql.Timestamp;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Data;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;;

@Data
@Entity
public class Receta {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long recetaId;

    private Timestamp fecha;

    private String diagnostico;
    private boolean vigencia;
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "citaId" , referencedColumnName = "citaId")
    private Cita cita;
}
