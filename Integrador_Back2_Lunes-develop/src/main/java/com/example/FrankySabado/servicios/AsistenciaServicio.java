package com.example.FrankySabado.servicios;

import com.example.FrankySabado.ayudas.EstadosAsistencia;
import com.example.FrankySabado.modelos.Asistencia;
import com.example.FrankySabado.modelos.dtos.AsistenciaDTO;
import com.example.FrankySabado.repositorios.IAsistenciaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsistenciaServicio {

    private final IAsistenciaRepositorio asistenciaRepositorio;

    public AsistenciaServicio(IAsistenciaRepositorio asistenciaRepositorio) {
        this.asistenciaRepositorio = asistenciaRepositorio;
    }

    // Crear asistencia a partir de DTO (valida campos básicos y evita fecha futura)
    public AsistenciaDTO crearAsistencia(AsistenciaDTO dto) {
        validateDtoForCreate(dto);

        EstadosAsistencia estado = null;
        if (StringUtils.hasText(dto.getEstado())) {
            estado = EstadosAsistencia.fromValue(dto.getEstado());
        }

        Asistencia entidad = new Asistencia();
        entidad.setEstudianteNombre(dto.getEstudianteNombre());
        entidad.setGrado(dto.getGrado());
        entidad.setAsignatura(dto.getAsignatura());
        entidad.setFecha(dto.getFecha());
        entidad.setHora(dto.getHora() != null ? dto.getHora() : LocalTime.now());
        entidad.setEstado(estado);
        entidad.setObservacion(dto.getObservacion());
        entidad.setUsuarioId(dto.getUsuarioId());

        Asistencia guardada = asistenciaRepositorio.save(entidad);

        AsistenciaDTO res = new AsistenciaDTO();
        res.setUsuarioId(guardada.getUsuarioId());
        res.setNombreUsuario(null);
        res.setEstudianteNombre(guardada.getEstudianteNombre());
        res.setGrado(guardada.getGrado());
        res.setAsignatura(guardada.getAsignatura());
        res.setFecha(guardada.getFecha());
        res.setHora(guardada.getHora());
        res.setEstado(guardada.getEstado() != null ? guardada.getEstado().getValue() : null);
        res.setObservacion(guardada.getObservacion());
        return res;
    }

    // Actualizar asistencia por id
    public AsistenciaDTO actualizarAsistencia(Integer id, AsistenciaDTO dto) {
        if (id == null) throw new IllegalArgumentException("El id es obligatorio para actualizar.");
        Asistencia existente = asistenciaRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Asistencia no encontrada con id " + id));

        if (dto.getFecha() != null && dto.getFecha().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser futura.");
        }

        if (StringUtils.hasText(dto.getEstudianteNombre())) existente.setEstudianteNombre(dto.getEstudianteNombre());
        if (StringUtils.hasText(dto.getGrado())) existente.setGrado(dto.getGrado());
        if (StringUtils.hasText(dto.getAsignatura())) existente.setAsignatura(dto.getAsignatura());
        if (dto.getFecha() != null) existente.setFecha(dto.getFecha());
        if (dto.getHora() != null) existente.setHora(dto.getHora());
        if (StringUtils.hasText(dto.getObservacion())) existente.setObservacion(dto.getObservacion());
        if (StringUtils.hasText(dto.getEstado())) existente.setEstado(EstadosAsistencia.fromValue(dto.getEstado()));
        if (dto.getUsuarioId() != null) existente.setUsuarioId(dto.getUsuarioId());

        Asistencia actualizado = asistenciaRepositorio.save(existente);

        AsistenciaDTO res = new AsistenciaDTO();
        res.setUsuarioId(actualizado.getUsuarioId());
        res.setNombreUsuario(null);
        res.setEstudianteNombre(actualizado.getEstudianteNombre());
        res.setGrado(actualizado.getGrado());
        res.setAsignatura(actualizado.getAsignatura());
        res.setFecha(actualizado.getFecha());
        res.setHora(actualizado.getHora());
        res.setEstado(actualizado.getEstado() != null ? actualizado.getEstado().getValue() : null);
        res.setObservacion(actualizado.getObservacion());
        return res;
    }

    // Eliminar asistencia
    public void eliminarAsistencia(Integer id) {
        if (id == null) throw new IllegalArgumentException("El id es obligatorio para eliminar.");
        Asistencia existente = asistenciaRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Asistencia no encontrada con id " + id));
        asistenciaRepositorio.delete(existente);
    }

    // Listar todas las asistencias (simple)
    public List<AsistenciaDTO> listarTodas() {
        return asistenciaRepositorio.findAll().stream()
                .map(a -> {
                    AsistenciaDTO dto = new AsistenciaDTO();
                    dto.setUsuarioId(a.getUsuarioId());
                    dto.setNombreUsuario(null);
                    dto.setEstudianteNombre(a.getEstudianteNombre());
                    dto.setGrado(a.getGrado());
                    dto.setAsignatura(a.getAsignatura());
                    dto.setFecha(a.getFecha());
                    dto.setHora(a.getHora());
                    dto.setEstado(a.getEstado() != null ? a.getEstado().getValue() : null);
                    dto.setObservacion(a.getObservacion());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Validaciones básicas para creación
    private void validateDtoForCreate(AsistenciaDTO dto) {
        if (dto == null) throw new IllegalArgumentException("El DTO no puede ser nulo.");
        if (!StringUtils.hasText(dto.getEstudianteNombre())) throw new IllegalArgumentException("El nombre del estudiante es obligatorio.");
        if (!StringUtils.hasText(dto.getGrado())) throw new IllegalArgumentException("El grado es obligatorio.");
        if (!StringUtils.hasText(dto.getAsignatura())) throw new IllegalArgumentException("La asignatura es obligatoria.");
        if (dto.getFecha() == null) throw new IllegalArgumentException("La fecha es obligatoria.");
        if (dto.getFecha().isAfter(LocalDate.now())) throw new IllegalArgumentException("La fecha no puede ser futura.");
        if (!StringUtils.hasText(dto.getEstado())) throw new IllegalArgumentException("El estado es obligatorio.");
        // conversión de estado para validar valor válido
        try {
            EstadosAsistencia.fromValue(dto.getEstado());
        } catch (Exception ex) {
            throw new IllegalArgumentException("Estado inválido: " + dto.getEstado());
        }
        if (dto.getUsuarioId() == null) throw new IllegalArgumentException("El usuarioId es obligatorio.");
    }
}