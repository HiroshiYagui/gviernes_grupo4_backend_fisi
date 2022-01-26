package com.freecode.redditclone.model.Ids;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
public class Cita_UsuarioId implements Serializable {
    private Long cita_id;
    private Long Historial_id;

}
