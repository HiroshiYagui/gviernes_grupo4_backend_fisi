package com.clinica.clinicaapp.exceptions;

public class CitaNotFoundException extends RuntimeException {
    public CitaNotFoundException(String Message){
        super(Message);
    }
}
