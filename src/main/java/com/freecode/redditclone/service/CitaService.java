package com.freecode.redditclone.service;



import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.dto.CitaDispDto;
import com.freecode.redditclone.dto.EspecialidadAndFechaDto;
import com.freecode.redditclone.dto.RespDto;
import com.freecode.redditclone.exceptions.SpringException;
import com.freecode.redditclone.exceptions.RecetaNotFoundException;
import com.freecode.redditclone.exceptions.CitaNotFoundException;
import com.freecode.redditclone.mapper.CitaMapper;
import com.freecode.redditclone.model.Cita;
import com.freecode.redditclone.model.Receta;
import com.freecode.redditclone.repository.CitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static java.util.stream.Collectors.toList;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public List<RespDto> getByEspecialidad(String especialidad){
        List<Cita> citas=citaRepository.findAllByEspecialidad(especialidad);
        List<Date> dates=new ArrayList<Date>();
        dates.add(Date.valueOf("2022-01-24"));
        dates.add(Date.valueOf("2022-01-25"));
        dates.add(Date.valueOf("2022-01-26"));
        dates.add(Date.valueOf("2022-01-27"));
        dates.add(Date.valueOf("2022-01-28"));
        dates.add(Date.valueOf("2022-01-29"));
        dates.add(Date.valueOf("2022-01-30"));
        List<RespDto> respDtos=new ArrayList<RespDto>();
        int index=0;
        
        for(Cita cita:citas){
            if(index<7){
            if(dates.get(index).compareTo(cita.getFecha())==0 && cita.isDisponible()){
                respDtos.add(new RespDto(index,true));
                index++;
            }
            else if(cita.getFecha().compareTo((dates.get(index)))!=0){
                respDtos.add(new RespDto(index,false));
                index++;
            }
            }
        }

        return respDtos;
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
