package com.freecode.redditclone.repository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.freecode.redditclone.model.Cita_Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface Cita_UsuarioRepository extends JpaRepository<Cita_Usuario,Long> {
    Optional<Cita_Usuario> findById(Long id);

    @Query("select cita_usuario.cita_id from cita_usuario where Historial_id= :historial_id")
    List<Long> findAllByHistorial_id(@Param("historial_id") Long Historial_id );
}
