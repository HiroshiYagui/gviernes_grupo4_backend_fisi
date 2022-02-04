package com.freecode.redditclone.service;



import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.dto.CitaDispDto;
import com.freecode.redditclone.dto.EspecialidadAndFechaDto;
import com.freecode.redditclone.dto.RespDto;
import com.freecode.redditclone.dto.RespHDto;
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
import java.sql.Time;
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
        List<Date> fechacitas=citaRepository.findDistinctFechas(especialidad);
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
        int xedni=0;
        
        while(index<dates.size()){
            if(xedni<fechacitas.size()){
                if(dates.get(index).compareTo(fechacitas.get(xedni))<0){
                    respDtos.add(new RespDto(index,false));
                    index++;
                }
                else if(dates.get(index).compareTo((fechacitas.get(xedni)))==0){
                    respDtos.add(new RespDto(index,true));
                    xedni++;
                    index++;
                }else{
                    xedni++;
                }
            }else{
                    respDtos.add(new RespDto(index,false));
                    index++;
                }
        }

        return respDtos;
    }

    @Transactional(readOnly=true)
    public List<RespHDto> getByEspecialidadAndFecha(String especialidad, Date fecha){
        List<Time> tiemposcitas=citaRepository.findDistinctHoras(especialidad, fecha);
        List<Time> times=new ArrayList<Time>();
        times.add(Time.valueOf("09:00:00"));
        times.add(Time.valueOf("09:20:00"));
        times.add(Time.valueOf("09:40:00"));
        times.add(Time.valueOf("10:00:00"));
        times.add(Time.valueOf("10:20:00"));
        times.add(Time.valueOf("10:40:00"));
        times.add(Time.valueOf("11:00:00"));
        times.add(Time.valueOf("11:20:00"));
        times.add(Time.valueOf("11:40:00"));
        times.add(Time.valueOf("14:00:00"));
        times.add(Time.valueOf("14:20:00"));
        times.add(Time.valueOf("14:40:00"));
        times.add(Time.valueOf("15:00:00"));
        times.add(Time.valueOf("15:20:00"));
        times.add(Time.valueOf("15:40:00"));
        times.add(Time.valueOf("16:00:00"));
        times.add(Time.valueOf("16:20:00"));
        times.add(Time.valueOf("16:40:00"));
        times.add(Time.valueOf("17:00:00"));
        times.add(Time.valueOf("17:20:00"));
        times.add(Time.valueOf("17:40:00"));
        List<RespHDto> respDtos=new ArrayList<RespHDto>();
        int index=0;
        int xedni=0;
        while(index<times.size()){
            if(xedni<tiemposcitas.size()){
            if(times.get(index).compareTo(tiemposcitas.get(xedni))<0){
                respDtos.add(new RespHDto(index,false));
                index++;
            }
            else if(times.get(index).compareTo((tiemposcitas.get(xedni)))==0){
                respDtos.add(new RespHDto(index,true));
                xedni++;
                index++;
            }else{
                xedni++;
            }
        }else{
                respDtos.add(new RespHDto(index,false));
                index++;
        }
        }

        return respDtos;
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
