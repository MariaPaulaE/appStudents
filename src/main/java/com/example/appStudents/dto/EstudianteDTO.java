package com.example.appStudents.dto;

public class EstudianteDTO {

    // Atributos básicos: los datos que vamos a enviar o recibir
    private Long id;
    private String nombre;
    private Long grupoId; // Este campo indica a qué grupo pertenece el estudiante (por ID)

    //Constructor vacío requerido por Spring para crear objetos automáticamente
    public EstudianteDTO() {}

    //Constructor con parámetros: útil cuando convertimos desde la entidad
    public EstudianteDTO(Long id, String nombre, Long grupoId) {
        this.id = id;
        this.nombre = nombre;
        this.grupoId = grupoId;
    }

    // GETTERS y SETTERS para que Spring pueda leer y escribir los datos
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

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    //Método equals para comparar si dos objetos DTO son iguales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Mismo objeto
        if (obj == null || getClass() != obj.getClass()) return false;

        EstudianteDTO otro = (EstudianteDTO) obj;

        if (!id.equals(otro.id)) return false;
        if (!nombre.equals(otro.nombre)) return false;
        return grupoId != null ? grupoId.equals(otro.grupoId) : otro.grupoId == null;
    }

    // Método toString para mostrar la información del objeto como texto
    @Override
    public String toString() {
        return "EstudianteDTO [id=" + id + ", nombre=" + nombre + ", grupoId=" + grupoId + "]";
    }
}


