package com.example.appStudents.model;

import jakarta.persistence.*;

@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación con profesor (muchas asignaturas pueden ser impartidas por un mismo profesor)
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesores profesor;

    // Relación con curso (una asignatura pertenece a un curso)
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Asignatura() {}

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

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}






