package com.example.appStudents.dto;

import java.time.LocalDate;

// DTO para transferir los datos de Asistencia entre la API y la base de datos
public class AsistenciaDTO {

    private Long id;
    private Long estudianteId;
    private Long asignaturaId;
    private LocalDate fecha;
    private Boolean estado; // se cambió de "presente" a "estado"

    public AsistenciaDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
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



