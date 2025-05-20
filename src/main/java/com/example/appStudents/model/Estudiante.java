package com.example.appStudents.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity // Esta clase es una entidad JPA (tabla en la base de datos)
public class Estudiante {

    @Id // Indica que este campo es la clave primaria (ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incrementa el ID (1, 2, 3...)
    private Long id;

    @Column(nullable = false) // El campo nombre no puede estar vacío en la base de datos
    private String nombre;

    // Relación Muchos a Uno: varios estudiantes pueden pertenecer a un mismo grupo
    @ManyToOne(fetch = FetchType.LAZY) // LAZY significa que no carga el grupo hasta que se use
    @JoinColumn(name = "grupo_id") // Esta columna es la clave foránea en la tabla estudiante
    private Grupo grupo;

    // Relación Uno a Muchos: un estudiante puede tener muchas asistencias
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Para evitar errores de recursión infinita al convertir a JSON
    private List<Asistencia> asistencias;

    //Constructor vacío: requerido por JPA (Spring lo usa automáticamente)
    public Estudiante() {}

    //Constructor con nombre (opcional, útil para crear objetos rápidamente)
    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    //GETTERS y SETTERS: permiten acceder y modificar los campos

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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }
}






