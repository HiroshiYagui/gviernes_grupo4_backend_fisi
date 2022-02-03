package com.clinica.clinicaapp.service;



import com.clinica.clinicaapp.dto.CitaDto;
import com.clinica.clinicaapp.dto.CitaDispDto;
import com.clinica.clinicaapp.dto.EspecialidadAndFechaDto;
import com.clinica.clinicaapp.exceptions.SpringException;
import com.clinica.clinicaapp.exceptions.RecetaNotFoundException;
import com.clinica.clinicaapp.exceptions.CitaNotFoundException;
import com.clinica.clinicaapp.mapper.CitaMapper;
import com.clinica.clinicaapp.model.Cita;
import com.clinica.clinicaapp.model.Receta;
import com.clinica.clinicaapp.repository.CitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static java.util.stream.Collectors.toList;

import java.util.List;

@Service
@Transactional
public class CitaService {
    @Autowired
    private  CitaRepository citaRepository;
    @Autowired
    private CitaMapper citaMapper;

    @Transactional
    public void create(CitaDto citaDto){
        
        citaRepository.save(citaMapper.map(citaDto));
    }

    @Transactional(readOnly=true)
    public CitaDto getCita(Long id){
        Cita cita= citaRepository.findById(id)
                    .orElseThrow(() -> new CitaNotFoundException(id.toString()));
        return citaMapper.mapToDto(cita);            
    }

    @Transactional(readOnly=true)
    public List<CitaDto> getAllCitas(){
        return citaRepository.findAll()
                .stream()
                .map(citaMapper::mapToDto)
                .collect(toList());
        
    }

    @Transactional
    public void delete(Long id){
        citaRepository.delete(citaRepository.getById(id));
    }

    @Transactional
    public void modify(CitaDto citaDto, Long id){
        Cita cita=citaRepository.getById(id);
        citaMapper.UpdateFromDto(citaDto, cita);
        citaRepository.save(cita);
    }

    @Transactional(readOnly=true)
    public List<CitaDispDto> getByEspecialidad(String especialidad){
        List<Cita> citas=citaRepository.findAllByEspecialidad(especialidad);
        return citas.stream().map(citaMapper::mapToDispDto).collect(toList());
    }

    @Transactional(readOnly=true)
    public List<CitaDispDto> getByEspecialidadAndFecha(EspecialidadAndFechaDto especialidadAndFechaDto){
        List<Cita> citas=citaRepository.findAllByEspecialidadAndFecha(especialidadAndFechaDto.getEspecialidad(), especialidadAndFechaDto.getFecha());
        return citas.stream().map(citaMapper::mapToDispDto).collect(toList());
    }

/*
    @Transactional(readOnly=true)
    public List<CitaDto> getCitaByReceta(Long recetaId ){
        Receta receta=recetaRepository.findById(recetaId)
                            .orElseThrow(()-> new RecetaNotFoundException(recetaId.toString()));
        List<Cita> citas=citaRepository.findAllByReceta(receta);
        return citas.stream().map(citaMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly=true)
    public List<CitaDto> getCitaByUsernarme(String username){
        User user=userRepository.findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException(username));
        return citaRepository.findByUser(user)
                                .stream()
                                .map(citaMapper::mapToDto)
                                .collect(toList());
    }
*/
}
