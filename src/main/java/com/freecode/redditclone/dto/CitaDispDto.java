package com.freecode.redditclone.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class CitaDispDto {
    private String especialidad;
    private Time hora;
    private Date fecha;
    private boolean disponible;
}
