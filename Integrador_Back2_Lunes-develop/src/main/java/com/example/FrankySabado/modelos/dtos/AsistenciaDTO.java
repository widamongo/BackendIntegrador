package com.example.FrankySabado.modelos.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class AsistenciaDTO {
    private Integer id; // <-- agregado: id de la entidad (PK)
    private Integer usuarioId;
    private String nombreUsuario; // opcional si lo puedes obtener
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime hora;
    private String estudianteNombre;
    private String grado;
    private String asignatura;
    // usando nombre del enum
    private String estado;
    private String observacion;

    public AsistenciaDTO() {}

    public AsistenciaDTO(Integer id, Integer usuarioId, String nombreUsuario, LocalDate fecha, LocalTime hora,
                         String estudianteNombre, String grado, String asignatura,
                         String estado, String observacion) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.hora = hora;
        this.estudianteNombre = estudianteNombre;
        this.grado = grado;
        this.asignatura = asignatura;
        this.estado = estado;
        this.observacion = observacion;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getEstudianteNombre() { return estudianteNombre; }
    public void setEstudianteNombre(String estudianteNombre) { this.estudianteNombre = estudianteNombre; }

    public String getGrado() { return grado; }
    public void setGrado(String grado) { this.grado = grado; }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
}