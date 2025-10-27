package com.example.FrankySabado.modelos.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class AsistenciaDTO {
    private Integer usuarioId;
    private String nombreUsuario; // opcional si se puede obtener
    private String estudianteNombre;
    private String grado;
    private String asignatura;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime hora;

    // usando nombre del enum (ej. "presente", "ausente", "tardanza", "justificado")
    private String estado;

    // corresponde al campo "observaciones" del formulario React
    private String observacion;

    public AsistenciaDTO() {}

    public AsistenciaDTO(Integer usuarioId, String nombreUsuario, String estudianteNombre,
                         String grado, String asignatura, LocalDate fecha, LocalTime hora,
                         String estado, String observacion) {
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.estudianteNombre = estudianteNombre;
        this.grado = grado;
        this.asignatura = asignatura;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.observacion = observacion;
    }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getEstudianteNombre() { return estudianteNombre; }
    public void setEstudianteNombre(String estudianteNombre) { this.estudianteNombre = estudianteNombre; }

    public String getGrado() { return grado; }
    public void setGrado(String grado) { this.grado = grado; }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
}