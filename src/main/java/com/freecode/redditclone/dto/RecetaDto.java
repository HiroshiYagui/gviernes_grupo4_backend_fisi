package com.freecode.redditclone.dto;

import java.sql.Date;

import com.stripe.param.UsageRecordCreateOnSubscriptionItemParams.Timestamp;

import lombok.Data;

@Data
public class RecetaDto {
    private String diagnostico;
    private Timestamp fecha;
    private boolean vigencia;
    private Long cita_id;
}
