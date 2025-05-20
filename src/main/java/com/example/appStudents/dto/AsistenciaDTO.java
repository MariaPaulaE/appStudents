package com.example.appStudents.dto;

import java.time.LocalDate;

public class AsistenciaDTO {

    private Long id;
    private LocalDate fecha;      // Fecha de la asistencia
    private boolean presente;     // true = asistió, false = ausente
    private Long estudianteId;    // A quién pertenece la asistencia
    private Long asignaturaId;    // A qué asignatura corresponde (relación agregada)

    public AsistenciaDTO() {}

    //Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public boolean isPresente() { return presente; }
    public void setPresente(boolean presente) { this.presente = presente; }

    public Long getEstudianteId() { return estudianteId; }
    public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }

    public Long getAsignaturaId() { return asignaturaId; }
    public void setAsignaturaId(Long asignaturaId) { this.asignaturaId = asignaturaId; }
}


