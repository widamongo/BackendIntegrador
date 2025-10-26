package com.example.FrankySabado.repositorios;

import com.example.FrankySabado.modelos.Asistencia;
import com.example.FrankySabado.ayudas.EstadosAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAsistenciaRepositorio extends JpaRepository<Asistencia, Integer> {
    // Buscar asistencias por fecha exacta
    List<Asistencia> findByFecha(LocalDate fecha);
    //buscar por id
    Asistencia findById(int id);

    // Buscar asistencias por estado
    List<Asistencia> findByEstado(EstadosAsistencia estado);

    // Buscar asistencias por observación exacta
    List<Asistencia> findByObservacion(String observacion);

    // Buscar asistencias que contengan una palabra en la observación
    List<Asistencia> findByObservacionContaining(String observacion);
}