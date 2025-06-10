package com.example.appStudents;

import com.example.appStudents.model.Curso;
import com.example.appStudents.model.Estudiantes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CursoTest {
    @Test
    public void probarGettersSettersCurso() {
        // Crear curso
        Curso curso = new Curso();

        // Crear estudiante de prueba
        Estudiantes estudiante = new Estudiantes();
        estudiante.setId(1L);
        estudiante.setNombre("Laura");

        // Asignar datos
        curso.setId(1L);
        curso.setNombre("Grado 10-B");
        curso.setEstudiantes(List.of(estudiante));

        // Verificaciones
        assertEquals(1L, curso.getId());
        assertEquals("Grado 10-B", curso.getNombre());
        assertEquals("Laura", curso.getEstudiantes().get(0).getNombre());
    }
}
