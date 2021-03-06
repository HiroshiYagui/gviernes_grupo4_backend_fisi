package com.freecode.redditclone.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freecode.redditclone.dto.Cita_UsuarioDto;
import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.dto.CitaDispDto;
import com.freecode.redditclone.dto.EspecialidadAndFechaDto;
import com.freecode.redditclone.dto.HistorialDto;
import com.freecode.redditclone.dto.MedicamentoDto;
import com.freecode.redditclone.service.Cita_UsuarioService;
import com.freecode.redditclone.service.MedicamentoService;
import com.freecode.redditclone.service.Receta_MedicamentoService;
import com.freecode.redditclone.service.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.ResponseEntity.status;

@RequestMapping("api/receta")
@RestController
public class Receta_medicamentoController {
    @Autowired
    private MedicamentoService medicamentoService;

    @Autowired
    private Receta_MedicamentoService receta_medicamentoService;

    @GetMapping("/filterMedicamentos/{id}")
    public ResponseEntity<Map<String,List<MedicamentoDto>>> getMedicamentosByReceta(@PathVariable Long id){
        Map<String,List<MedicamentoDto>> medicamentoMap = new HashMap<>();
        medicamentoMap.put("Medicamentos", receta_medicamentoService.getByReceta(id));
       // medicamentoMap.put("Medicamentos", medicamentoService.getMedicamento(id));
        return status(HttpStatus.OK).body(medicamentoMap);
    }



   /* @Autowired
    private  Cita_UsuarioService cita_UsuarioService;
    @Autowired
    private  CitaService citaService;


    @PostMapping("/save")
    public ResponseEntity<Void> Save(@RequestBody Cita_UsuarioDto cita_UsuarioDto){
        System.out.println(cita_UsuarioDto);
        cita_UsuarioService.save(cita_UsuarioDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/filterEspecialidad/{especialidad}")
    public ResponseEntity<List<CitaDispDto>> getCitabyEspecialidad(@PathVariable String especialidad){
        return status(HttpStatus.OK).body(citaService.getByEspecialidad(especialidad));
    }

    @GetMapping("/filterFecha")
    public ResponseEntity<List<CitaDispDto>> getCitabyEspecialidadAndFecha(@RequestBody EspecialidadAndFechaDto especialidadAndFechaDto){
        return status(HttpStatus.OK).body(citaService.getByEspecialidadAndFecha(especialidadAndFechaDto));
    }

    @GetMapping("/listUser")
    public ResponseEntity<List<CitaDispDto>> getListCitaByUsuario(@RequestBody HistorialDto historialDto){
        return status(HttpStatus.OK).body(cita_UsuarioService.getByUsuario(historialDto));
    }

    @GetMapping("/list/{id}")
    public ResponseEntity <CitaDispDto> getCitaByUsuario(@RequestBody HistorialDto historialDto, @PathVariable int id){
        return status(HttpStatus.OK).body(cita_UsuarioService.getByUsuario(historialDto).get(id));
    }
/*
    @GetMapping
    public ResponseEntity<List<CitaDto>> getAllCitas(){
        return status(HttpStatus.OK).body(citaService.getAllCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDto> getCita(@PathVariable Long id){
        return status(HttpStatus.OK).body(citaService.getCita(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteCita(@PathVariable Long id){
        citaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> ModifyCita(@PathVariable Long id, @RequestBody CitaDto citaDto){
        citaService.modify(citaDto,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    */
}
