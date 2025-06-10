package com.example.appStudents;

import com.example.appStudents.model.Curso;
import com.example.appStudents.model.Estudiantes;
import com.example.appStudents.model.Profesores;
import com.example.appStudents.model.Usuario;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProfesoresTest {
    @Test
    public void probarGettersSettersProfesores() {
        // Crear profesor
        Profesores profesor = new Profesores();

        // Crear usuario
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setCorreo("profesor@mail.com");

        // Crear curso
        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNombre("Grado 11-B");

        // Crear estudiante
        Estudiantes estudiante = new Estudiantes();
        estudiante.setId(1L);
        estudiante.setNombre("Carlos");

        // Asignar datos
        profesor.setId(1L);
        profesor.setNombre("Luis Pérez");
        profesor.setUsuario(usuario);
        profesor.setCursos(List.of(curso));
        profesor.setEstudiantes(List.of(estudiante));

        // Verificar con asserts
        assertEquals(1L, profesor.getId());
        assertEquals("Luis Pérez", profesor.getNombre());
        assertEquals("profesor@mail.com", profesor.getUsuario().getCorreo());
        assertEquals("Grado 11-B", profesor.getCursos().get(0).getNombre());
        assertEquals("Carlos", profesor.getEstudiantes().get(0).getNombre());
    }
}
