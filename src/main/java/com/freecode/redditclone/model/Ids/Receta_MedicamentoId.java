package com.freecode.redditclone.model.Ids;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Receta_MedicamentoId implements Serializable {
    private Long Receta_id;
    private Long Medicamento_id;
}
