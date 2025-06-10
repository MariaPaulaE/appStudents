package com.example.appStudents;

import com.example.appStudents.model.Asignatura;
import com.example.appStudents.model.Curso;
import com.example.appStudents.model.Profesores;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AsignaturaTest {
    @Test
    public void probarGettersSettersAsignatura() {
        // Crear una nueva asignatura
        Asignatura asignatura = new Asignatura();

        // Crear objetos de prueba para curso y profesor
        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNombre("Grado 10-A");

        Profesores profesor = new Profesores();
        profesor.setId(1L);
        profesor.setNombre("Luis Pérez");

        // Usar los setters para asignar valores
        asignatura.setId(1L);
        asignatura.setNombre("Matemáticas");
        asignatura.setCurso(curso);
        asignatura.setProfesor(profesor);

        // Verificar que los valores fueron correctamente asignados
        assertEquals(1L, asignatura.getId());
        assertEquals("Matemáticas", asignatura.getNombre());
        assertEquals("Grado 10-A", asignatura.getCurso().getNombre());
        assertEquals("Luis Pérez", asignatura.getProfesor().getNombre());
    }
}
