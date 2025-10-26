package com.example.FrankySabado.modelos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "hvhu01")
public class hvhu01 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "resumen", nullable = false, unique = false)
    private String resumen;
    @Column(name = "intereses", nullable = false, unique = false)
    private String intereses;
    @Column(name = "experiencia", nullable = false, unique = false)
    private String experiencia;
    @Column(name = "proyectos", nullable = false, unique = false)
    private String proyectos;
    @Column(name = "estudianteId", nullable = false, unique = true)
    private Integer estudianteId;


    @OneToOne //(mappedBy = "estudiante")
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id")
    @JsonBackReference(value = "relacionestudianteperfilestudiante")
    private Estudiante estudiante;




    public hvhu01() {
    }


    public hvhu01(Integer id, String resumen, String intereses, String experiencia, String proyectos, Integer estudianteId) {
        this.id = id;
        this.resumen = resumen;
        this.intereses = intereses;
        this.experiencia = experiencia;
        this.proyectos = proyectos;
        this.estudianteId = estudianteId;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getProyectos() {
        return proyectos;
    }

    public void setProyectos(String proyectos) {
        this.proyectos = proyectos;
    }
    public Integer getEstudianteId() {
        return estudianteId;
    }
    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }
}



