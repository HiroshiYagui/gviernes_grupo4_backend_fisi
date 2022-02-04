package com.freecode.redditclone.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class RecetaDto {
    private String diagnostico;
    private Date fecha;
    private boolean vigencia;
    private Long cita_id;
}
