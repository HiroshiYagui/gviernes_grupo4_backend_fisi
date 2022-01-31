package com.freecode.redditclone.repository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.freecode.redditclone.model.Cita_Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Cita_UsuarioRepository extends JpaRepository<Cita_Usuario,Long> {
    Optional<Cita_Usuario> findById(Long id);

    
    List<Cita_Usuario> findAllByhistorial_historialId(Long Historial_id );
}
