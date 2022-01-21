package com.freecode.redditclone.controller;
import java.util.List;

import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.dto.CitaDto;
import com.freecode.redditclone.service.CitaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.ResponseEntity.status;

@RequestMapping("api/citas")
@RestController
@AllArgsConstructor
@Slf4j
public class CitaController {
    
    private final CitaService postService;


    @PostMapping
    public ResponseEntity<Void> CreateCita(@RequestBody CitaDto citaDto){
        postService.create(citaDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CitaDto>> getAllCitas(){
        return status(HttpStatus.OK).body(postService.getAllCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDto> getCita(@PathVariable Long id){
        return status(HttpStatus.OK).body(postService.getCita(id));
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

