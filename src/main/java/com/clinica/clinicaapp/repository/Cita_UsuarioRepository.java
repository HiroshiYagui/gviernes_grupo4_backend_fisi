package com.clinica.clinicaapp.repository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.clinica.clinicaapp.model.Cita_Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Cita_UsuarioRepository extends JpaRepository<Cita_Usuario,Long> {
    Optional<Cita_Usuario> findById(Long id);

    
    List<Cita_Usuario> findAllByhistorial_historialId(Long Historial_id );
}
