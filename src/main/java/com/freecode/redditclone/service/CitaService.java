package com.freecode.redditclone.service;



import com.freecode.redditclone.dto.CitaDto;
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
