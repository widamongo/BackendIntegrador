package com.example.FrankySabado.modelos;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name= "grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre", nullable = false, unique = false)
    private String nombre;
    @Column(name= "semestre", nullable = false, unique = false)
    private String semestre;

    //Relacion uno a muchos con materia
    @OneToMany (mappedBy = "grupo", cascade = CascadeType.ALL)

    private List<Materia> materias = new ArrayList<>();



    public Grupo() {
    }

    public Grupo(Integer id, String nombre, String semestre) {
        this.id = id;
        this.nombre = nombre;
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

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
