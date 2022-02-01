package com.freecode.redditclone.model.Ids;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Receta_MedicamentoId implements Serializable {
    private Long receta_id;
    private Long medicamento_id;
}
