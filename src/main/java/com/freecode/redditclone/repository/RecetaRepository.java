package com.freecode.redditclone.repository;

import com.freecode.redditclone.model.Receta;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta,Long>  {
    
    Optional<Receta> findByIdCita(Long Cita_id);



}
