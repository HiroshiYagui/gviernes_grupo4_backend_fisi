package com.clinica.clinicaapp.exceptions;

public class RecetaNotFoundException extends RuntimeException {
    public RecetaNotFoundException(String Message){
        super(Message);
    }
}
