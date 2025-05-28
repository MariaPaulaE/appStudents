package com.example.appStudents.dto;

// DTO para la entidad Asignatura
public class AsignaturaDTO {

    private Long id;
    private String nombre;

    // ID del profesor que imparte la asignatura
    private Long profesorId;

    // ID del curso al que pertenece la asignatura
    private Long cursoId;

    public AsignaturaDTO() {}

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

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}



