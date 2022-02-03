package com.clinica.clinicaapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Medicamento {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long medicamentoId;

    private String nombre;
}
