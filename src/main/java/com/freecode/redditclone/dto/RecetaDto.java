package com.freecode.redditclone.dto;

import java.sql.Date;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RecetaDto {
    private Timestamp fecha;

    private String diagnostico;

    private boolean vigencia;
    private Long cita_id;
}
