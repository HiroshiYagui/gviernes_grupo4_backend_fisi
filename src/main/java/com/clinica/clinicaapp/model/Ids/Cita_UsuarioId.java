package com.clinica.clinicaapp.model.Ids;

import java.io.Serializable;

import javax.persistence.Embeddable;


import lombok.Data;

@Data
@Embeddable
public class Cita_UsuarioId implements Serializable {
    private Long cita_id;
    private Long historial_id;

}
