package com.freecode.redditclone.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Long usuario_id;

    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private String tipo_usuario;
    private String codigo;
    private String correo_electronico;
    private String contrasena;
    private String telefono;
    @OneToOne(fetch=LAZY)
    @JoinColumn(name="historial_id",referencedColumnName="historial_id")
    private Historial historial;
}
