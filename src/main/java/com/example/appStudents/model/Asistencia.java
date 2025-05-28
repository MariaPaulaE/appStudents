package com.example.appStudents.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con la entidad Estudiantes
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiantes estudiante;

    // Relación con la entidad Asignatura
    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    // Fecha de la asistencia
    private LocalDate fecha;

    // Estado de asistencia: true (presente), false (ausente)
    private Boolean estado;

    public Asistencia() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}



