package com.freecode.redditclone.controller;

import com.freecode.redditclone.dto.PagoDto;
import com.freecode.redditclone.dto.PagoRespuestaDto;
import com.freecode.redditclone.service.PagosService;
import com.freecode.redditclone.dto.PaymentIntentDto;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;
@RequestMapping("api/pagos")
@RestController
public class PagoController {
    @Autowired
    private PagosService pagosService;

    @PostMapping("/Intent")
    public ResponseEntity<PaymentIntentDto> CreateCheckout(@RequestBody PagoDto pagoDto){
        return status(HttpStatus.OK).body(pagosService.CreatePaymentIntent(pagoDto));
    }
}
