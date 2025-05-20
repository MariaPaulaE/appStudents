package com.example.appStudents.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Maestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Un maestro puede tener varias asignaturas
    @OneToMany(mappedBy = "maestro")
    private List<Asignatura> asignaturas;

    public Maestro() {}

    public Maestro(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Asignatura> getAsignaturas() { return asignaturas; }
    public void setAsignaturas(List<Asignatura> asignaturas) { this.asignaturas = asignaturas; }
}





