package com.clinica.clinicaapp.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class CitaDto {

    private String especialidad;
    private Time hora;
    private Date fecha;
}

