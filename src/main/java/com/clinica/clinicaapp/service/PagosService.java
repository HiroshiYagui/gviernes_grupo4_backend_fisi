package com.clinica.clinicaapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.clinicaapp.dto.PagoDto;
import com.clinica.clinicaapp.dto.PagoRespuestaDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
@Transactional
public class PagosService {

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    public PaymentIntent CreatePaymentIntent(PagoDto pagoDto){
        Stripe.apiKey = stripeSecretKey;
        try{
        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                    .setCurrency(pagoDto.getCurrency())
                    .setAmount(pagoDto.getAmount())
                    .addPaymentMethodType("card")
                    .build();
        PaymentIntent intent = PaymentIntent.create(createParams);
        return intent;    
        }catch(StripeException se) {
            se.printStackTrace();
            
        }
        return null;
    }
}
