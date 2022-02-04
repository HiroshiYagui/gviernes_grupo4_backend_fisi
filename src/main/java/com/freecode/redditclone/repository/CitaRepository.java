package com.freecode.redditclone.repository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

import java.sql.Time;
import java.sql.Date;

import com.freecode.redditclone.model.Cita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Long> {
    Optional<Cita> findById(Long id);

    Optional<Cita> findByHoraAndFechaAndEspecialidad(Time Hora,Date Fecha,String Especialidad);

    List<Cita> findAllByEspecialidad(String Especialidad);

    @Query(value="select distinct c.fecha from cita c where c.especialidad=?1 and c.disponible=true order by c.fecha asc", nativeQuery=true)
    List<Date> findDistinctFechas(String Especialidad);

    List<Cita> findAllByEspecialidadAndFecha(String Especialidad,Date Fecha);

    List<Cita> findAllByCitaIdIn(List<Long> cita_ids);
}

