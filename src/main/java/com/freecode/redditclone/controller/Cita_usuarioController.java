package com.freecode.redditclone.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freecode.redditclone.dto.Cita_UsuarioDto;
import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.dto.CitaDispDto;
import com.freecode.redditclone.dto.EspecialidadAndFechaDto;
import com.freecode.redditclone.dto.HistorialDto;
import com.freecode.redditclone.dto.RespDto;
import com.freecode.redditclone.dto.RespHDto;
import com.freecode.redditclone.service.Cita_UsuarioService;
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

@RequestMapping("api/citas")
@RestController
public class Cita_usuarioController {
    @Autowired
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
    public ResponseEntity<Map<String,List<RespDto>>> getCitabyEspecialidad(@PathVariable String especialidad){
        Map<String,List<RespDto>> citaMap = new HashMap<>();
        citaMap.put("fechas", citaService.getByEspecialidad(especialidad));
        return status(HttpStatus.OK).body(citaMap);
    }

    @GetMapping("/filterFecha")
    public ResponseEntity<Map<String,List<RespHDto>>> getCitabyEspecialidadAndFecha(@RequestBody EspecialidadAndFechaDto especialidadAndFechaDto){
        Map<String,List<RespHDto>> citaMap = new HashMap<>();
        citaMap.put("horas", citaService.getByEspecialidadAndFecha(especialidadAndFechaDto));
        return status(HttpStatus.OK).body(citaMap);
    }

    @GetMapping("/listUser/{hid}")
    public ResponseEntity<Map<String,List<CitaDispDto>>> getListCitaByUsuario(@PathVariable Long hid){
        
        Map<String,List<CitaDispDto>> citaMap = new HashMap<>();
        citaMap.put("results", cita_UsuarioService.getByUsuario(hid));
        return status(HttpStatus.OK).body(citaMap);
    }

    @GetMapping("/list/{hid}/{id}")
    public ResponseEntity <CitaDispDto> getCitaByUsuario(@PathVariable Long hid, @PathVariable int id){
        return status(HttpStatus.OK).body(cita_UsuarioService.getByUsuario(hid).get(id));
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
