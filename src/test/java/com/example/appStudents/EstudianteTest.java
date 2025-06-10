package com.example.appStudents;

import com.example.appStudents.model.Curso;
import com.example.appStudents.model.Estudiantes;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EstudianteTest {
    @Test
    public void probarGettersSettersEstudiantes() {
        // Crear estudiante
        Estudiantes estudiante = new Estudiantes();

        // Crear curso
        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNombre("Grado 11-A");

        // Asignar datos al estudiante
        estudiante.setId(1L);
        estudiante.setIdEstudiante("STU123");
        estudiante.setNombre("Ana");
        estudiante.setApellido("López");
        estudiante.setFechaNacimiento(LocalDate.of(2008, 10, 15));
        estudiante.setGenero("F");
        estudiante.setGrado("11");
        estudiante.setDireccion("Calle 123");
        estudiante.setTelefono("3001234567");
        estudiante.setEmail("ana@mail.com");
        estudiante.setFechaIngreso(LocalDate.of(2024, 2, 10));
        estudiante.setCurso(curso);

        // Verificaciones
        assertEquals("STU123", estudiante.getIdEstudiante());
        assertEquals("Ana", estudiante.getNombre());
        assertEquals("López", estudiante.getApellido());
        assertEquals("F", estudiante.getGenero());
        assertEquals("11", estudiante.getGrado());
        assertEquals("Calle 123", estudiante.getDireccion());
        assertEquals("3001234567", estudiante.getTelefono());
        assertEquals("ana@mail.com", estudiante.getEmail());
        assertEquals("Grado 11-A", estudiante.getCurso().getNombre());
    }
}
