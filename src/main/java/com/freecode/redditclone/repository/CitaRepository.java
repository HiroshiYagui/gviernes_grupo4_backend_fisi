package com.freecode.redditclone.repository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

import java.sql.Time;
import java.sql.Date;

import com.freecode.redditclone.model.Cita;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Long> {
    Optional<Cita> findById(Long id);

    Optional<Cita> findByHoraAndFechaAndEspecialidad(Time Hora,Date Fecha,String Especialidad);

    List<Cita> findAllByEspecialidad(String Especialidad);

    List<Cita> findAllByEspecialidadAndFecha(String Especialidad,Date Fecha);

    List<Cita> findAllByCitaIdIn(List<Long> cita_ids);
}

