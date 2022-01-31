package com.freecode.redditclone.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.websocket.OnClose;

import com.freecode.redditclone.model.Ids.Receta_MedicamentoId;

import lombok.Data;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;



@Data
@Entity
public class Receta_medicamento  {

    @EmbeddedId
    private Receta_MedicamentoId receta_MedicamentoId;

    @MapsId("recetaId")
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "recetaId",referencedColumnName = "recetaId")
    private Receta receta;

    @MapsId("medicamentoId")
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "medicamentoId",referencedColumnName = "medicamentoId")
    private Medicamento medicamento;

    private int cantidad;
}
