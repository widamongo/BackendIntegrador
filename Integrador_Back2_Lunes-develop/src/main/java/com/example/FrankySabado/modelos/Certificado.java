package com.example.FrankySabado.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="certificado")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name= "nombre", nullable = false, unique = false)
    private  String nombre;
    @Column(name= "instituto", nullable = false, unique = false)
    private  String instituto;
    @Column(name = "fecha", nullable = false, unique = false)
    private LocalDate fecha;
    @Column(name ="urlArchivo", nullable = false, unique = false)
    private  String urlArchivo;

    public Certificado(){
    }

    public Certificado(Integer id, String nombre, String instituto, LocalDate fecha, String urlArchivo) {
        this.id = id;
        this.nombre = nombre;
        this.instituto = instituto;
        this.fecha = fecha;
        this.urlArchivo = urlArchivo;
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

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }
}
