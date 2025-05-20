package com.example.appStudents.dto;

public class AsignaturaDTO {

    private Long id;
    private String nombre;
    private Long maestroId;  // ID del maestro asignado
    private Long grupoId;    // ID del grupo asignado

    public AsignaturaDTO() {}

    //Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Long getMaestroId() { return maestroId; }
    public void setMaestroId(Long maestroId) { this.maestroId = maestroId; }

    public Long getGrupoId() { return grupoId; }
    public void setGrupoId(Long grupoId) { this.grupoId = grupoId; }
}


