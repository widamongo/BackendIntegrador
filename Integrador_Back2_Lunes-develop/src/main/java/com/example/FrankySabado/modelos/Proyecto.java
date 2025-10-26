package com.example.FrankySabado.modelos;

import jakarta.persistence.*;

@Entity
@Table(name="proyecto")

public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "titulo", nullable = false, unique = false)
    private String titulo;
    @Column(name = "descripcion", nullable = false, unique = false)
    private String descripcion;
    @Column(name = "url", nullable = false, unique = false)
    private String url;
    @Column(name = "tecnologias", nullable = false, unique = false)
    private String tecnologias;

    public Proyecto() {
    }

    public Proyecto(Integer id, String titulo, String descripcion, String url, String tecnologias) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.tecnologias = tecnologias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }
}
