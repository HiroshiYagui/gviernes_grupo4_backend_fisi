package com.freecode.redditclone.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freecode.redditclone.dto.PagoDto;
import com.freecode.redditclone.dto.PaymentIntentDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
@Transactional
public class PagosService {

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    public PaymentIntentDto CreatePaymentIntent(PagoDto pagoDto){
        Stripe.apiKey = stripeSecretKey;
        try{
        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                    .setCurrency(pagoDto.getCurrency())
                    .setAmount(pagoDto.getAmount())
                    .addPaymentMethodType("card")
                    .build();
        PaymentIntent intent = PaymentIntent.create(createParams);
        PaymentIntentDto paymentIntentDto=new PaymentIntentDto();
        paymentIntentDto.setClientSecret(intent.getClientSecret());
        return paymentIntentDto;    
        }catch(StripeException se) {
            se.printStackTrace();
            
        }
        return null;
    }
}
