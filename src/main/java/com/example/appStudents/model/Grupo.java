package com.example.appStudents.model;

import jakarta.persistence.*;
import java.util.List;

@Entity // Marca esta clase como una entidad JPA (una tabla en la base de datos)
public class Grupo {

    @Id // Este campo será la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se genera automáticamente (auto incrementa)
    private Long id;

    private String nombre; // Nombre del grupo (por ejemplo: "Grupo A")

    //Relación Uno a Muchos: un grupo puede tener muchos estudiantes
    @OneToMany(mappedBy = "grupo") // 'grupo' es el nombre del atributo en la clase Estudiante
    private List<Estudiante> estudiantes;

    //Constructor vacío requerido por JPA
    public Grupo() {}

    //Constructor opcional para crear un grupo rápidamente
    public Grupo(String nombre) {
        this.nombre = nombre;
    }

    //GETTERS y SETTERS para acceder y modificar los datos

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

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}





