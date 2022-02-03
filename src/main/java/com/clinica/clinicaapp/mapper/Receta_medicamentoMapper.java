package com.clinica.clinicaapp.mapper;

import com.clinica.clinicaapp.dto.CitaDto;
import com.clinica.clinicaapp.model.Cita;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface Receta_medicamentoMapper {
/*
    @Mapping(target = "disponible", constant = "true")
    public Cita map(CitaDto citaDto);

    public  CitaDto mapToDto(Cita cita);

    public void UpdateFromDto(CitaDto citaDto, @MappingTarget Cita cita);*/
}
