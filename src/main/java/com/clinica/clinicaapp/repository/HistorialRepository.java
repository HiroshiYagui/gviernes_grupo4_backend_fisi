package com.clinica.clinicaapp.repository;

import com.clinica.clinicaapp.model.Historial;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<Historial,Long> {
    Optional<Historial> findById(Long id);
}
