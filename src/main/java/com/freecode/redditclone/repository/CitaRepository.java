package com.freecode.redditclone.repository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.freecode.redditclone.model.Cita;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Long> {
    Optional<Cita> findById(Long id);

    List<Cita> findByEspecialidad(String especialidad);
}

