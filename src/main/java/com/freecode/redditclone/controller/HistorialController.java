package com.freecode.redditclone.controller;

import com.freecode.redditclone.dto.SolicitudDto;
import com.freecode.redditclone.model.NotificationEmail;
import com.freecode.redditclone.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/historial")
@RestController
public class HistorialController {
    
    @Autowired
    private MailService mailService;

    @PostMapping("/enviar")
    public ResponseEntity<Void> EnviarHistorial(@RequestBody SolicitudDto solicitudDto ){
        mailService.sendMail(new NotificationEmail("Solicitud de Historial Medico",
        solicitudDto.getCorreo_electronico(),"Yo, "+ solicitudDto.getNombre()+" "+
        solicitudDto.getApellido()+ " con DNI "+ solicitudDto.getDni()+ " solicito que se me sea entregado una copia fisica de mi Historial Medico"));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
