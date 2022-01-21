package com.freecode.redditclone.dto;

import java.sql.Date;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaDto {
    private String especialidad;
    private Time hora;
    private Date fecha;
}

