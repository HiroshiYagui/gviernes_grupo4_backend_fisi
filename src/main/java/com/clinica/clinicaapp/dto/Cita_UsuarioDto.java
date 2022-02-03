package com.clinica.clinicaapp.dto;

import java.sql.Date;
import java.sql.Time;
import lombok.Data;

@Data
public class Cita_UsuarioDto {
    private String especialidad;
    private Time hora;
    private Date fecha;
    private Long historial_id;
}
