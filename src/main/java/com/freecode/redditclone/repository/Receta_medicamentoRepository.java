package com.freecode.redditclone.repository;

import com.freecode.redditclone.model.Receta_medicamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Receta_medicamentoRepository extends JpaRepository<Receta_medicamento,Long> {
    
}
