package com.example.FrankySabado.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Materia")

public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "codigo")
    private Integer codigo;
    @ManyToOne
    @JoinColumn(name="grupo_id")
    private Grupo grupo;

}
