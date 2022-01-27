package com.freecode.redditclone.repository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

import java.sql.Time;
import java.sql.Date;

import com.freecode.redditclone.model.Cita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Long> {
    Optional<Cita> findById(Long id);

    Optional<Cita> findByHoraAndFechaAndEspecialidad(Time Hora,Date Fecha,String Especialidad);

    List<Cita> findAllByEspecialidad(String Especialidad);

    List<Cita> findAllByEspecialidadAndFecha(String Especialidad,Date Fecha);

    @Query("select * from cita where id_cita in :cita_ids")
    List<Cita> findByIds(@Param("cita_ids")List<Long>cita_ids);
}

