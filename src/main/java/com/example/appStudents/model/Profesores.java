package com.example.appStudents.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "profesores")
public class Profesores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación con asignaturas (un profesor puede tener muchas asignaturas)
    @OneToMany(mappedBy = "profesor")
    private List<Asignatura> asignaturas;

    // Relación con cursos (un profesor puede impartir muchos cursos)
    @ManyToMany
    @JoinTable(
            name = "profesor_curso",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

    // Relación con estudiantes (un profesor puede orientar a varios estudiantes)
    @ManyToMany
    @JoinTable(
            name = "profesor_estudiante",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private List<Estudiantes> estudiantes;

    // Relación uno a uno con usuario
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Profesores() {}

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

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Estudiantes> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiantes> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}







