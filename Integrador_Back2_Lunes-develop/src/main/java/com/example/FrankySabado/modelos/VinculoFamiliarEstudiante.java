package com.example.FrankySabado.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "VinculoFamiliar")
public class VinculoFamiliarEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_familiar", nullable = false)
    private Integer id_familiar;
    @Column(name = "id_estudiante", nullable = false)
    private Integer id_estudiante;
    @Column(name = "autorizado", nullable = false)
    private boolean autorizado;

    public VinculoFamiliarEstudiante() {
    }

    public VinculoFamiliarEstudiante(Integer id, Integer id_familiar, Integer id_estudiante, boolean autorizado) {
        this.id = id;
        this.id_familiar = id_familiar;
        this.id_estudiante = id_estudiante;
        this.autorizado = autorizado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_familiar() {
        return id_familiar;
    }

    public void setId_familiar(Integer id_familiar) {
        this.id_familiar = id_familiar;
    }

    public Integer getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Integer id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
}
