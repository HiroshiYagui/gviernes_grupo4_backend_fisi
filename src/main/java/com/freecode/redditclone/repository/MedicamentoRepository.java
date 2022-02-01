package com.freecode.redditclone.repository;

import java.util.Optional;

import com.freecode.redditclone.model.Medicamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento,Long> {
    Optional<Medicamento> findById(Long id);
}
