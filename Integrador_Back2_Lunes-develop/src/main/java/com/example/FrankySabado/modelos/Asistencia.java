package com.example.FrankySabado.modelos;

import com.example.FrankySabado.ayudas.EstadosAsistencia;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Datos provenientes del formulario React
    @Column(name = "estudiante_nombre", nullable = false)
    private String estudianteNombre;

    @Column(name = "grado", nullable = false)
    private String grado;

    @Column(name = "asignatura", nullable = false)
    private String asignatura;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "observacion", length = 500)
    private String observacion;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadosAsistencia estado;

    // vínculo mínimo con el usuario que registra (puede ser id del usuario en la tabla users)
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    public Asistencia() {}

    public Asistencia(Integer id, String estudianteNombre, String grado, String asignatura,
                      LocalDate fecha, LocalTime hora, String observacion,
                      EstadosAsistencia estado, Integer usuarioId) {
        this.id = id;
        this.estudianteNombre = estudianteNombre;
        this.grado = grado;
        this.asignatura = asignatura;
        this.fecha = fecha;
        this.hora = hora;
        this.observacion = observacion;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

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

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }

    public EstadosAsistencia getEstado() { return estado; }
    public void setEstado(EstadosAsistencia estado) { this.estado = estado; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }
}