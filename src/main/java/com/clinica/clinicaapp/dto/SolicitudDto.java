package com.clinica.clinicaapp.dto;

import lombok.Data;

@Data
public class SolicitudDto {
    
    private String nombre;
    private String apellido;
    private String dni;
    private String correo_electronico;
}
