package com.freecode.redditclone.controller;

import java.util.List;

import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.dto.MedicamentoDto;
import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.service.CitaService;
import com.freecode.redditclone.service.MedicamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.ResponseEntity.status;

@RequestMapping("api/medicamentos")
@RestController
public class MedicamentoController {
    @Autowired
    private  MedicamentoService medicamentoService;


    @PostMapping
    public ResponseEntity<Void> CreateMedicamento(@RequestBody MedicamentoDto medicamentoDto){
        medicamentoService.create(medicamentoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> getAllMedicamentos(){
        return status(HttpStatus.OK).body(medicamentoService.getAllMedicamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDto> getMedicamento(@PathVariable Long id){
        return status(HttpStatus.OK).body(medicamentoService.getMedicamento(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteMedicamento(@PathVariable Long id){
        medicamentoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> ModifyMedicamento(@PathVariable Long id, @RequestBody MedicamentoDto medicamentoDto){
        medicamentoService.modify(medicamentoDto,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
/*
    @GetMapping("by-subreddit/{id}")
    public ResponseEntity<List<CitaDto>> getCitaByReceta(Long id){
        return status(HttpStatus.OK).body(postService.getCitaByReceta(id));
    }

    @GetMapping("by-user/{id}")
    public ResponseEntity<List<CitaDto>> getCitaByUsername(@PathVariable String username){
        return status(HttpStatus.OK).body(postService.getCitaByUsernarme(username));
    }
    */
}


