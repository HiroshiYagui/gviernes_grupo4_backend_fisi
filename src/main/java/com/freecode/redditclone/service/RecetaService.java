package com.freecode.redditclone.service;



import com.freecode.redditclone.dto.RecetaDto;
import com.freecode.redditclone.dto.CitaDispDto;
import com.freecode.redditclone.dto.EspecialidadAndFechaDto;
import com.freecode.redditclone.exceptions.SpringException;
import com.freecode.redditclone.exceptions.RecetaNotFoundException;
import com.freecode.redditclone.exceptions.CitaNotFoundException;
import com.freecode.redditclone.mapper.RecetaMapper;
import com.freecode.redditclone.model.Cita;
import com.freecode.redditclone.model.Receta;
import com.freecode.redditclone.repository.CitaRepository;
import com.freecode.redditclone.repository.RecetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static java.util.stream.Collectors.toList;

import java.util.List;

@Service
@Transactional
public class RecetaService {
    @Autowired
    private  CitaRepository citaRepository;

    @Autowired
    private  RecetaRepository recetaRepository;

    @Autowired
    private RecetaMapper recetaMapper;


    @Transactional(readOnly=true)
    public RecetaDto getReceta(Long id){
        Cita cita= citaRepository.findById(id)
                    .orElseThrow(() -> new CitaNotFoundException(id.toString()));
        
        Receta receta = recetaRepository.findById(cita.getCitaId())
                    .orElseThrow(() -> new RecetaNotFoundException(cita.toString()));
         
        return recetaMapper.mapToDto(receta);            
    }


 /*   @Autowired
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
