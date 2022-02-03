package com.clinica.clinicaapp.repository;

import com.clinica.clinicaapp.model.Receta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta,Long>  {
    
}
