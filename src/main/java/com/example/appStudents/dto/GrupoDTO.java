package com.example.appStudents.dto;

public class GrupoDTO {

    private Long id;       // ID del grupo
    private String nombre; // Nombre del grupo (ej: "Grupo A")

    // Constructor vacío necesario para que Spring pueda usar esta clase
    public GrupoDTO() {}

    //Getters y Setters: permiten leer y escribir los datos

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
}


