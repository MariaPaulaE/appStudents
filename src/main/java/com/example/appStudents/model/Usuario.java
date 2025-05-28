package com.example.appStudents.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String correo;
    private String contraseña;
    private String rol;

    // Relación inversa con Maestro (un usuario tiene un maestro)
    @OneToOne(mappedBy = "usuario")
    private Profesores maestro;

    public Usuario() {}

    public Usuario(String correo, String contraseña, String rol) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Profesores getMaestro() {
        return maestro;
    }

    public void setMaestro(Profesores maestro) {
        this.maestro = maestro;
    }
}


