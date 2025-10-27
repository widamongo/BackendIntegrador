package com.example.FrankySabado.repositorios;

import com.example.FrankySabado.ayudas.EstadosAsistencia;
import com.example.FrankySabado.modelos.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IAsistenciaRepositorio extends JpaRepository<Asistencia, Integer> {

    // Buscar asistencias por usuario
    List<Asistencia> findByUsuarioId(Integer usuarioId);

    // Buscar asistencia única de un usuario en una fecha
    Optional<Asistencia> findByUsuarioIdAndFecha(Integer usuarioId, LocalDate fecha);

    // Buscar asistencias por fecha (útil para filtros simples)
    List<Asistencia> findByFecha(LocalDate fecha);

    // Buscar asistencias por una lista de usuarios en una fecha (para filtrar por grupo)
    List<Asistencia> findByFechaAndUsuarioIdIn(LocalDate fecha, List<Integer> usuarioIds);

    // Filtros adicionales alineados al formulario del frontend
    List<Asistencia> findByEstudianteNombreContainingIgnoreCase(String nombre);
    List<Asistencia> findByGrado(String grado);
    List<Asistencia> findByAsignatura(String asignatura);
    List<Asistencia> findByEstado(EstadosAsistencia estado);
}