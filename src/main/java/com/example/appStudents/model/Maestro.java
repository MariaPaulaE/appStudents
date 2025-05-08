package com.example.appStudents.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Maestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String materia;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonBackReference
    private Estudiante estudiante;

    public Maestro(){}

    public Maestro(Long id, String nombre, String materia) {
        this.id = id;
        this.nombre = nombre;
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    //    // Getters y Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getNombre() { return nombre; }
//    public void setNombre(String nombre) { this.nombre = nombre; }
//
//    public String getMateria() { return materia; }
//    public void setMateria(String materia) { this.materia = materia; }
//
//    public List<Estudiante> getEstudiantes() { return estudiantes; }
//    public void setEstudiantes(List<Estudiante> estudiantes) { this.estudiantes = estudiantes; }
}


