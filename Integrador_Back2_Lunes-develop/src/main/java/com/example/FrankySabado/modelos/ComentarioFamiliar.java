package com.example.FrankySabado.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "comentariosFamiliares")
public class ComentarioFamiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name = "comentario", nullable = false,unique = false,length = 255)
    private String comentario;

    @Column(name = "fecha", nullable = false,unique = false)
    private LocalDate fecha;

    public ComentarioFamiliar() {
    }

    public ComentarioFamiliar(Integer id, String comentario, LocalDate fecha) {
        this.id = id;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
