package com.freecode.redditclone.dto;

import lombok.Data;

@Data
public class RespDto {
    private int dia;
    private boolean disponible;

    public RespDto(int dia,boolean disponible){
        this.dia=dia;
        this.disponible=disponible;
    }
}
