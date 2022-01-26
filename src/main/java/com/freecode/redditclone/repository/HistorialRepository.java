package com.freecode.redditclone.repository;

import com.freecode.redditclone.model.Historial;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<Historial,Long> {
    Optional<Historial> findById(Long id);
}
