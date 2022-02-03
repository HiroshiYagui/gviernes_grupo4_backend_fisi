package com.clinica.clinicaapp.dto;

import lombok.Data;

@Data
public class PagoRespuestaDto {
    private Long amount;
    private String currency;
    private String clientSecret;

    public PagoRespuestaDto(Long amount, String currency,String clientSecret){
        this.amount=amount;
        this.currency=currency;
        this.clientSecret=clientSecret;
    }
}
