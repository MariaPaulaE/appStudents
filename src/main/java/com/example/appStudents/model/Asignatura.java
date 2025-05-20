package com.example.appStudents.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación con Maestro (una asignatura tiene un maestro)
    @ManyToOne
    @JoinColumn(name = "maestro_id")
    private Maestro maestro;

    // Relación con Grupo (una asignatura tiene un grupo)
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    // Relación con Asistencia (una asignatura tiene muchas asistencias)
    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
    private List<Asistencia> asistencias;

    public Asignatura() {}

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    //Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Maestro getMaestro() { return maestro; }
    public void setMaestro(Maestro maestro) { this.maestro = maestro; }

    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }

    public List<Asistencia> getAsistencias() { return asistencias; }
    public void setAsistencias(List<Asistencia> asistencias) { this.asistencias = asistencias; }
}





