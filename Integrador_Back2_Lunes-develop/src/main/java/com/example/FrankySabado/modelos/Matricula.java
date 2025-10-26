package com.example.FrankySabado.modelos;

import jakarta.persistence.*;

@Entity
@Table(name="matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "matricula_id", nullable = false)
    private int matricula_id;
    @Column(name = "semestre", nullable = false)
    private int semestre;

    public Matricula() {
    }

    public Matricula(Integer id, String nombre, int matricula_id, int semestre) {
        this.id = id;
        this.nombre = nombre;
        this.matricula_id = matricula_id;
        this.semestre = semestre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula_id() {
        return matricula_id;
    }

    public void setMatricula_id(int matricula_id) {
        this.matricula_id = matricula_id;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}