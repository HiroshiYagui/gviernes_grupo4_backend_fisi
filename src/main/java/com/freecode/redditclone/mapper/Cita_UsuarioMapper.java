package com.freecode.redditclone.mapper;

import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.model.Cita;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface Cita_UsuarioMapper {

    @Mapping(target = "disponible", constant = "true")
    public Cita map(CitaDto citaDto);

    public  CitaDto mapToDto(Cita cita);

    public void UpdateFromDto(CitaDto citaDto, @MappingTarget Cita cita);
}
