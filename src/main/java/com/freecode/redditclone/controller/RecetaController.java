package com.freecode.redditclone.controller;

import java.util.List;

import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.dto.RecetaDto;
import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.service.CitaService;
import com.freecode.redditclone.service.RecetaService;

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

@RequestMapping("api/receta")
@RestController
public class RecetaController {
  /*  @Autowired
    private  CitaService citaService;
*/
    private RecetaService recetaService;

    @GetMapping("/filterReceta/{hid}")
    public ResponseEntity<RecetaDto> getRecetaByCita(@PathVariable Long id){
        return status(HttpStatus.OK).body(recetaService.getReceta(id));
    }




/*
    @PostMapping
    public ResponseEntity<Void> CreateCita(@RequestBody CitaDto citaDto){
        citaService.create(citaDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

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


