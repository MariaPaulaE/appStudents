package com.example.appStudents.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Maestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String materia;

    @OneToMany(mappedBy = "maestro", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public void setEstudiantes(List<Estudiante> estudiantes) { this.estudiantes = estudiantes; }
}


