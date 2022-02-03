package com.clinica.clinicaapp.controller;

import com.clinica.clinicaapp.dto.PagoDto;
import com.clinica.clinicaapp.dto.PagoRespuestaDto;
import com.clinica.clinicaapp.service.PagosService;
import com.stripe.model.PaymentIntent;

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
    public ResponseEntity<PaymentIntent> CreateCheckout(@RequestBody PagoDto pagoDto){
        return status(HttpStatus.OK).body(pagosService.CreatePaymentIntent(pagoDto));
    }
}
