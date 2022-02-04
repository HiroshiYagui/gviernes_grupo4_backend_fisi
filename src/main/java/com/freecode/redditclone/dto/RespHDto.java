package com.freecode.redditclone.dto;

import lombok.Data;

@Data
public class RespHDto {
    private int hora;
    private boolean disponible;

    public RespHDto(int hora,boolean disponible){
        this.hora=hora;
        this.disponible=disponible;
    }
}
