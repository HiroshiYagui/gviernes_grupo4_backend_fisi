package com.clinica.clinicaapp.repository;

import java.util.Optional;

import com.clinica.clinicaapp.model.Medicamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento,Long> {
    Optional<Medicamento> findById(Long id);
}
