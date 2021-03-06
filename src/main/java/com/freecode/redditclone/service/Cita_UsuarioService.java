package com.freecode.redditclone.service;

import com.freecode.redditclone.dto.CitaDispDto;
import com.freecode.redditclone.dto.Cita_UsuarioDto;
import com.freecode.redditclone.dto.HistorialDto;
import com.freecode.redditclone.exceptions.SpringException;
import com.freecode.redditclone.exceptions.RecetaNotFoundException;
import com.freecode.redditclone.exceptions.CitaNotFoundException;
import com.freecode.redditclone.mapper.Cita_UsuarioMapper;
import com.freecode.redditclone.model.Cita_Usuario;
import com.freecode.redditclone.model.Historial;
import com.freecode.redditclone.model.Receta;
import com.freecode.redditclone.model.Cita;
import com.freecode.redditclone.repository.Cita_UsuarioRepository;
import com.freecode.redditclone.repository.HistorialRepository;
import com.freecode.redditclone.repository.CitaRepository;
import com.freecode.redditclone.model.Ids.Cita_UsuarioId;
import com.freecode.redditclone.mapper.CitaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class Cita_UsuarioService {
    @Autowired
    private  Cita_UsuarioRepository cita_UsuarioRepository;
    
    @Autowired
    private  CitaRepository citaRepository;

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    private CitaMapper citaMapper;

    @Transactional
    public void save(Cita_UsuarioDto cita_UsuarioDto){
        
        Cita cita=citaRepository.findByHoraAndFechaAndEspecialidad(cita_UsuarioDto.getHora(),cita_UsuarioDto.getFecha(),cita_UsuarioDto.getEspecialidad())
                    .orElseThrow(() -> new CitaNotFoundException(cita_UsuarioDto.getEspecialidad()+cita_UsuarioDto.getFecha()+cita_UsuarioDto.getHora()));
        cita.setDisponible(false);
        Historial historial=historialRepository.findById(cita_UsuarioDto.getHistorial_id())
                            .orElseThrow(() -> new CitaNotFoundException(cita_UsuarioDto.getHistorial_id().toString()));
        Cita_Usuario cita_Usuario=new Cita_Usuario();
        cita_Usuario.setCita(cita);
        cita_Usuario.setHistorial(historial);
        cita_UsuarioRepository.save(cita_Usuario);
        citaRepository.save(cita);
    }

    @Transactional(readOnly=true)
    public List<CitaDispDto> getByUsuario(Long hid){
        List<Cita_Usuario> citas_usuarios=cita_UsuarioRepository.findAllByhistorial_historialId(hid);
        List<Cita> citasinUsuario= citas_usuarios.stream().map(Cita_Usuario::getCita).collect(toList());
        List<Long> citas_id=citasinUsuario.stream().map(Cita::getCitaId).collect(toList());
        List<Cita> citas=citaRepository.findAllByCitaIdIn(citas_id);
        return citas.stream().map(citaMapper::mapToDispDto).collect(toList());
    }
    
/*
    @Transactional(readOnly=true)
    public CitaDto getCita(Long id){
        Cita cita= cita_UsuarioRepository.findById(id)
                    .orElseThrow(() -> new CitaNotFoundException(id.toString()));
        return cita_UsuarioMapper.mapToDto(cita);            
    }

    @Transactional(readOnly=true)
    public List<CitaDto> getAllCitas(){
        return cita_UsuarioRepository.findAll()
                .stream()
                .map(cita_UsuarioMapper::mapToDto)
                .collect(toList());
        
    }

    @Transactional
    public void delete(Long id){
        cita_UsuarioRepository.delete(cita_UsuarioRepository.getById(id));
    }

    @Transactional
    public void modify(CitaDto citaDto, Long id){
        Cita_Usuario cita=cita_UsuarioRepository.getById(id);
        cita_UsuarioMapper.UpdateFromDto(citaDto, cita);
        cita_UsuarioRepository.save(cita);
    }
*/
}