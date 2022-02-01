package com.freecode.redditclone.service;



import com.freecode.redditclone.dto.MedicamentoDto;
import com.freecode.redditclone.exceptions.CitaNotFoundException;
import com.freecode.redditclone.mapper.MedicamentoMapper;
import com.freecode.redditclone.model.Medicamento;
import com.freecode.redditclone.repository.MedicamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static java.util.stream.Collectors.toList;

import java.util.List;

@Service
@Transactional
public class MedicamentoService {
    @Autowired
    private  MedicamentoRepository medicamentoRepository;
    @Autowired
    private MedicamentoMapper medicamentoMapper;

    @Transactional
    public void create(MedicamentoDto medicamentoDto){
        medicamentoRepository.save(medicamentoMapper.map(medicamentoDto));
    }

    @Transactional(readOnly=true)
    public MedicamentoDto getMedicamento(Long id){
        Medicamento medicamento= medicamentoRepository.findById(id)
                    .orElseThrow(() -> new CitaNotFoundException(id.toString()));
        return medicamentoMapper.mapToDto(medicamento);            
    }

    @Transactional(readOnly=true)
    public List<MedicamentoDto> getAllMedicamentos(){
        return medicamentoRepository.findAll()
                .stream()
                .map(medicamentoMapper::mapToDto)
                .collect(toList());
        
    }

    @Transactional
    public void delete(Long id){
        medicamentoRepository.delete(medicamentoRepository.getById(id));
    }

    @Transactional
    public void modify(MedicamentoDto medicamentoDto, Long id){
        Medicamento medicamento=medicamentoRepository.getById(id);
        medicamentoMapper.UpdateFromDto(medicamentoDto, medicamento);
        medicamentoRepository.save(medicamento);
    }
/*
    @Transactional(readOnly=true)
    public List<MedicamentoDispDto> getByEspecialidad(String especialidad){
        List<Medicamento> medicamentos=medicamentoRepository.findAllByEspecialidad(especialidad);
        return medicamentos.stream().map(medicamentoMapper::mapToDispDto).collect(toList());
    }

    @Transactional(readOnly=true)
    public List<MedicamentoDispDto> getByEspecialidadAndFecha(EspecialidadAndFechaDto especialidadAndFechaDto){
        List<Medicamento> citas=citaRepository.findAllByEspecialidadAndFecha(especialidadAndFechaDto.getEspecialidad(), especialidadAndFechaDto.getFecha());
        return citas.stream().map(citaMapper::mapToDispDto).collect(toList());
    }


    @Transactional(readOnly=true)
    public List<MedicamentoDto> getMedicamentoByReceta(Long recetaId ){
        Receta receta=recetaRepository.findById(recetaId)
                            .orElseThrow(()-> new RecetaNotFoundException(recetaId.toString()));
        List<Medicamento> citas=citaRepository.findAllByReceta(receta);
        return citas.stream().map(citaMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly=true)
    public List<MedicamentoDto> getMedicamentoByUsernarme(String username){
        User user=userRepository.findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException(username));
        return citaRepository.findByUser(user)
                                .stream()
                                .map(citaMapper::mapToDto)
                                .collect(toList());
    }
*/
}
