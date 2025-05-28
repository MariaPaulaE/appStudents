package com.example.appStudents.dto;

import java.util.List;

// DTO para transferir datos de la entidad Profesores
public class ProfesoresDTO {

    private Long id;
    private String nombre;

    // ID del usuario asociado
    private Long usuarioId;

    // IDs de los cursos asignados
    private List<Long> cursoIds;

    // IDs de las asignaturas asignadas
    private List<Long> asignaturaIds;

    // IDs de los estudiantes asignados
    private List<Long> estudianteIds;

    public ProfesoresDTO() {}

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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Long> getCursoIds() {
        return cursoIds;
    }

    public void setCursoIds(List<Long> cursoIds) {
        this.cursoIds = cursoIds;
    }

    public List<Long> getAsignaturaIds() {
        return asignaturaIds;
    }

    public void setAsignaturaIds(List<Long> asignaturaIds) {
        this.asignaturaIds = asignaturaIds;
    }

    public List<Long> getEstudianteIds() {
        return estudianteIds;
    }

    public void setEstudianteIds(List<Long> estudianteIds) {
        this.estudianteIds = estudianteIds;
    }
}






